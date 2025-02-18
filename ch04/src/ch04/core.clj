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

(defn more-than-1
  [texts]
  (into {}
        (filter #(> (second %) 1)
                (zipmap texts (map word-score texts)))))

;; (defn scores [texts] (reduce + #(word-score %) texts))

;; foldleft的な
(defn scores
  [texts]
  (reduce (fn [acc %] (+ acc (word-score %))) 0 texts))

(defn -main
  ""
  [& args]
  (println (sort-by-score ["ada" "haskell" "scala" "java" "rust"]))
  (println (more-than-1 ["ada" "haskell" "scala" "java" "rust"]))
  (println (scores ["ada" "haskell" "scala" "java" "rust" "go"])))

;; 高階関数

;; (defn create-filter-fn [threshold]
;;   (fn [[_ score]]
;;     (> score threshold)))

;; (defn filter-scores [filter-fn]
;;   (fn [score-map]
;;     (into {} (filter filter-fn score-map))))

;; (defn create-score-map [score-fn]
;;   (fn [texts]
;;     (zipmap texts (map score-fn texts))))

;; (defn create-more-than-n [threshold score-fn]
;;   (comp (filter-scores (create-filter-fn threshold))
;;         (create-score-map score-fn)))