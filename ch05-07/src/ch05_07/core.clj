(ns ch05-07.core
  (:gen-class))

(def scala-book [{:title "すごい本" :authors ["A" "B" "C"]}])
(def fiction-book   [{:title "いい本" :authors ["A"]} {:title "謎の本" :authors ["X"]}])

(def friend-list
  ["Ali" "QQQ" "Bob"])

(defn recommended-books
  [friend]
  (case friend
    "Ali" scala-book
    "Bob" fiction-book
    []))

(defn recommendations
  [friends]
  (mapcat #(recommended-books %) friends))

(defn authors
  [books]
  (vec
   (into #{} (mapcat :authors) books)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (-> (recommendations friend-list)
               (authors))))
