(ns virtual-dom.core
  (:require [reagent.core :as reagent :refer [atom]]
            [cljs.reader :refer [read-string]]
            [clojure.string :as str]
            [virtual-dom.grammar :as grammar]
            [virtual-dom.reify :as vdom]))

(enable-console-print!)

(defonce state-atom
  (let [cookie js/document.cookie
        code-str (if (not (empty? cookie))
                   (-> cookie
                       (str/split "a=")
                       second
                       (str/split ";")
                       first)
                   grammar/default-grammar-str)
        grammar (try (read-string code-str)
                     (catch js/Error e nil))
        code-str (if grammar code-str grammar/default-grammar-str)
        grammar (or grammar (read-string code-str))]
    (atom {:code-str code-str
           :grammar grammar
           :* 0
           :display :edit})))

(defn redo []
  (swap!
   state-atom
   #(update % :* inc)))

(defn edit []
  (swap!
   state-atom
   #(assoc % :display :edit)))

(def error-msg "There is an error in your grammar!")

(defn play []
  (swap!
   state-atom
   #(let [grammar (try
                    (read-string (:code-str %))
                    (catch js/Error e nil))]
      (if grammar
        (-> %
            (assoc :display :play)
            (assoc :grammar grammar)
            (assoc :message nil))
        (assoc % :message error-msg)))))

(defn text-change [e]
  (let [val (-> e .-target .-value)]
    (swap! state-atom #(assoc % :code-str val))))

(defn save []
  (let [grammar (try
                  (read-string (:code-str @state-atom))
                  (catch js/Error e nil))]
    (if grammar
      (do
        (set! js/document.cookie (str  "a=" (:code-str @state-atom)))
        (swap! state-atom #(assoc % :message "Grammar saved!"))
        (js/setTimeout
         (fn [] (swap! state-atom #(assoc % :message nil)))
         1500))
      (swap! state-atom #(assoc % :message error-msg)))))

(defn bullet [grammar command]
  [:li
   [:div.heart-flex
    [:div.heart]
    [:div.bullet-text (vdom/reify grammar command)]]])

(defn bullets [state]
  (let [{:keys [grammar code-str]} state]
   (into [:ul] (-> bullet (partial grammar) map) (:-> grammar))))

(defn play-buttons []
  [:div.buttons
   [:button.bottom {:on-click redo} "Again"]
   [:button.bottom {:on-click edit} "Edit"]])

(defn edit-buttons [state]
  (let [message (:message state)]
    [:div
     (when message [:p.message message])
     [(if message :div.buttons.message :div.buttons)
      [:button.bottom {:on-click save} "Save"]
      [:button.bottom {:on-click play} "Play"]]]))

(defmulti virtual-dom :display)

(defmethod virtual-dom :edit [state]
  [:div.virtual-dom-inner
   [:div.code-container
    [:textarea.code
     {:value (:code-str state)
      :on-change text-change}]]
   [edit-buttons state]
   [:p.readme
    [:span "Need some help? "]
    [:a {:href "https://github.com/MysteryMachine/virtual-dom/blob/master/README.md"
         :target "_none"}
     "Check out the README!"]]])

(defmethod virtual-dom :play [state]
  [:div.virtual-dom-inner
   [bullets state]
   [play-buttons]])

(defn virtual-dom-app []
  (let [state @state-atom]
    [:div.virtual-dom
     [:h1 "Virtual DOM"]
     [virtual-dom state]]))

(def outer-id "virtual-dom-outer")

(defn get-container [] (. js/document (getElementById outer-id)))

(reagent/render-component [virtual-dom-app] (get-container))

(defn on-js-reload [])

