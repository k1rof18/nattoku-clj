(ns ch01.core
  (:gen-class))

(require '[clojure.string :as str])

(defn- is-not-char? [c] #(not= % c))

(defn- filter-char [text c]
  (filter (is-not-char? c) (str/split text #"")))

(defn- word-score
  [text]
  (count (filter-char text "a")))

;; for / if などの方法に焦点を当てないこと。「a」を省いた文字列に焦点を当てる。
(defn- word-score-ans
  [text]
  (count (str/replace text #"a" "")))

(defn -main
  ""
  [& args]
  (println (word-score "imperative"))
  (println (word-score "no"))
  (println (word-score "declarative"))
  (println (word-score "yes"))
  (println "")
  (println (word-score-ans "imperative"))
  (println (word-score-ans "no"))
  (println (word-score-ans "declarative"))
  (println (word-score-ans "yes"))
  (println "")
  (println (inc 1))
  (println (get "abc" 0)))
