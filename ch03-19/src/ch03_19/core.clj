(ns ch03-19.core
  (:gen-class))

(defn first-two
  [items]
  (vec (take 2 items)))

(defn last-two
  [items]
  (vec (take-last 2 items)))

(defn moved-fst-two-to-end
  [items]
  (vec (concat (drop 2 items) (first-two items))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (first-two [1 2 3 4 5 6]))
  (println (last-two [1 2 3 4 5 6]))
  (println (moved-fst-two-to-end [1 2 3 4 5 6])))
