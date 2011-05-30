; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
(use 'clojure.contrib.math) 

(def natural-numbers (iterate inc 1))

; takes a collection
(defn square-of-sum [coll]
  (expt (reduce + coll) 2))

(defn sum-of-squares [coll]
  (reduce + (map #(expt % 2) coll)))

(defn diff-between-squares [coll]
  (- (square-of-sum coll) (sum-of-squares coll)))

(defn euler006 []
  (diff-between-squares (take 100 natural-numbers)))

(time (println (euler006)))

