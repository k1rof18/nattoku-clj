(ns ch06.core
  (:gen-class))

(require '[clojure.string :as str])

(defn period
  [show]
  (- (:end show) (:start show)))

(defn sortShows
  [shows]
  (sort-by #(period %) > shows))

(defn parseShow
  [s]
  (let
   [open (str/last-index-of s "(")
    close (str/last-index-of s ")")
    hf (str/last-index-of s "-")]

    {:title (str/trim (subs s 0 open))
     :start (Integer/parseInt (str/trim (subs s (inc open) hf)))
     :end (Integer/parseInt (str/trim (subs s (inc hf) close)))}))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  (->> ["秒終わり(2000-2002)" "2進数(2) (1000-2002)" "最近の(2000-2025)"]
       (map #(parseShow %))
       (sortShows)
       (run! println)))
