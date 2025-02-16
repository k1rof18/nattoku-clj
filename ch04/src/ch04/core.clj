(ns ch04.core
  (:gen-class))

(require '[clojure.string :as str])

(defn- penalty-a [text] (- (count text) (count (remove #(= \a %) text))))
(defn- penalty-s [text] (if (str/includes? text "s") 7 0))

(defn- penalty
  [text]
  (-> (penalty-s text)
      (+ (penalty-a text))))

(defn- bonus
  [text]
  (if (str/includes? text "c") 5 0))

(defn word-score
  [text]
  (-> text
      (count)
      (- (penalty text))
      (+ (bonus text))))

;; (defn sort-by-score
;;   [texts]
;;   (reverse (sort-by #(word-score %) texts)))

;; reverse使わなくていい
(defn sort-by-score
  [texts]
  (sort-by #(word-score %) > texts))

(defn -main
  ""
  [& args]
  (println (sort-by-score ["ada" "haskell" "scala" "java" "rust"])))
