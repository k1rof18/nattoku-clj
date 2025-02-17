(ns ch04-41.core
  (:gen-class))

(require '[clojure.string :as str])

(defn- larger-than [n nums] (filter #(< n %) nums))

(defn- dividible-by [n nums] (filter #(= (mod % n) 0) nums))

(defn- smaller-then-str [n ss] (filter #(< n (count %)) ss))

(defn- count-s [v]
  (-> v
      (count)
      (- (count (str/replace v #"s" "")))))

(defn- number-of-s [n ss] (filter #(< n (count-s %)) ss))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (larger-than 4 [1,2,3,4,5,6,7,1,2,3,4,5]))
  (println (dividible-by 5 [1,2,3,4,5,6,7,1,2,3,4,5]))
  (println (smaller-then-str 4 ["aaa" "aaaaa" "sss" "s" "sssss"]))
  ;; (println (count-s "asss"))
  (println (number-of-s 2 ["aaa" "aasasaa" "sss" "s" "sssss"])))
