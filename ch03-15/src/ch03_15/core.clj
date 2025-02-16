(ns ch03-15.core
  (:gen-class))

(require '[clojure.string :as str])

(defn initial
  [name]
  (-> (first (str/split name #" "))
      (get 0)
      (str ".")))

(defn abbreviate
  [name]
  (str
   (initial name)
   " "
   (second (str/split name #" "))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (abbreviate "A Rodriguez"))
  (println (abbreviate "A. Rodriguez"))
  (println (abbreviate "AAA Rodriguez")))
