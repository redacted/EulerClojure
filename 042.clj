(use 'clojure.set)

(def words (re-seq #"[^\",]+" (slurp "words.txt")))

(def triangle-nums 
          (map first (iterate (fn [[n m]] [(+ n m) (+ m 1)]) [1 2])))

;; could speed up by solving for inverse function - if the inverse results in
;; an integer, the number is triangular
(defn triangle? [n]
    (some true? (map #(= n %) (take-while #(>= n %) triangle-nums))))

(defn char-to-int [c]
  (- (int c) 64))

(defn word-total [s]
  (reduce + (map #(char-to-int % ) s)))

(def word-values (map #(word-total %) words))

(defn euler042 []
  (count (filter triangle? word-values)))

(time (println (euler042)))

