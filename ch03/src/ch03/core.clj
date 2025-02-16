(ns ch03.core
  (:gen-class))

(def init-times [])

(defn add-time [times time] (conj times time))

(defn- filter-warmup-time [times] (vec (rest times)))

(defn total-time [times] () (reduce + (filter-warmup-time times)))

(defn avg-time [times] (/ (total-time times) (count (filter-warmup-time times))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (-> init-times
               (add-time 15.5)
               (add-time 10.0)
               (add-time 8.0)
               (total-time)))
  (println (-> init-times
               (add-time 15.5)
               (add-time 10.0)
               (add-time 8.0)
               (avg-time)))
  (println "Hello, World!"))
