(ns virtual-dom.reify)

(declare reify)

(def str* (partial apply str))

(defn reify-vector [grammar form]
  (-> (partial reify grammar) (map form) str*))

(defn reify-list [grammar form]
  (reify grammar (rand-nth form)))

(defn reify-keyword [grammar form]
  (->> (get grammar form) (reify grammar)))

(defn reify [grammar form]
  (cond
    (list? form) (reify-list grammar form)
    (vector? form) (reify-vector grammar form)
    (keyword? form) (reify-keyword grammar form)
    :else (str form)))


