(ns ch02-10.core
  (:gen-class))

(def init-member [])

(defn add-member [members name] (conj members name))

(defn chip
  [member]
  (cond
    (= (count member) 0) 0
    (<= (count member) 2) 10
    :else 20))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println init-member)
  (println (-> init-member
               (add-member "k")
               (add-member "yo")
               (chip)))
  (println (-> init-member
               (add-member "k")
               (add-member "yo")
               (add-member "wa")
               (chip))))
