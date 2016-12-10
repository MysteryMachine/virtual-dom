(ns virtual-dom.core
  (:require [reagent.core :as reagent :refer [atom]]
            [cljs.reader :refer [read-string]]
            [virtual-dom.grammar :as grammar]
            [virtual-dom.reify :as vdom]))

(enable-console-print!)

(defonce state-atom
  (atom {:code-str grammar/default-grammar-str
         :grammar grammar/default-grammar
         :* 0}))

(defn redo []
  (swap!
   state-atom
   #(update % :* inc)))

(defn bullet [grammar command]
  [:li
   [:div.heart-flex
    [:div.heart]
    [:div.bullet-text (vdom/reify grammar command)]]])

(defn bullets [state]
  (let [{:keys [grammar code-str]} state]
   (into [:ul] (-> bullet (partial grammar) map) (:-> grammar))))

(defn redo-button []
  [:div.redo-outer
   [:button.redo {:onClick redo} "Redo"]])

(defn virtual-dom []
  (let [state @state-atom]
    [:div.virtual-dom
     [:h1 "Virtual DOM"]
     [:h2 "A virtual dom for your cyber submissive needs."]
     [:div.virtual-dom-inner
      [:p "You! Virtual DOM commands you to"]
      [bullets state]
      [redo-button]]]))

(def outer-id "virtual-dom-outer")

(defn get-container [] (. js/document (getElementById outer-id)))

(reagent/render-component [virtual-dom] (get-container))

(defn on-js-reload [])

