(ns ch05.core
  (:gen-class))

(require '[clojure.string :as strs])

(def book-list
  [{:title "すごい本" :authors ["A" "B" "C"]}
   {:title "いい本" :authors ["A"]}
   {:title "謎の本" :authors ["X"]}])

(def movie-list
  [{:title "全米が泣いた映画" :author "A"}
   {:title "全米が笑った映画" :author "A"}])

;; 著者ごとに映画化されたもの取得
(defn get-movie-by-author [author]
  (filter #(= author (% :author)) movie-list))

;; mapcatを使えば良い
;; (defn book-author-list []
;;   (distinct (reduce (fn [acc %] (concat acc (% :authors))) [] book-list)))

(defn book-authors [l]
  (into #{} (mapcat :authors) l))

(defn recommend-msg
  [movies]
  (map #(% :title) (flatten movies)))

(defn -main
  "Prints movies by authors of books in the book-list."
  [& args]
  (->> book-list
       (book-authors)
       (map get-movie-by-author)
       (remove empty?)
       (recommend-msg)
       (run! println)))
