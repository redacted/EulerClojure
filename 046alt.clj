(use '[clojure.contrib.lazy-seqs :only (primes)])
 
(defn prime? [n]
  (and (< 1 n)
       (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))
 
(def double-squares (map #(* 2 % %) (range)))
 
(defn compositable? [n]
  (some #(prime? (- n %)) (take-while #(> n %) double-squares)))
 
(defn euler-46 []
  (first (remove compositable? (remove prime? (iterate #(+ 2 %) 3)))))
 
(time (println (euler-46)))

