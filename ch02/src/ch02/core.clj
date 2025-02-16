(ns ch02.core
  (:gen-class))

(defn add-item [items item] (conj items item))

(def init-item [])

(defn discount-percentage [items] (if (some #(= % "book") items) 5 0))

(defn delete-item [items item] (filterv (complement #(= % item)) items))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (-> init-item
               (add-item "pen")))
  (println)
  (println (-> init-item
               (add-item "pen")
               (discount-percentage)))
  (println (-> init-item
               (add-item "pen")
               (add-item "book")
               (discount-percentage)))
  (println)
  (println (-> init-item
               (add-item "pen")
               (add-item "book")
               (add-item "bag")
               (delete-item "bag")))
  (println))
