(ns ch04-55.core
  (:gen-class))

(defn maximum
  [nums]
  (reduce
   (fn
     [acc %]
     (if (> % acc) % acc))
   (first nums)
   nums))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (maximum [1 2 3 4 3 2 1])))
