(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.string :only (join)]
     '[clojure.contrib.combinatorics :only (permutations)])

(defn prime? [n]
  (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes)))
 
(defn as-int [coll]  (Integer/parseInt (apply str coll)))
 
(defn euler041alt [s]
  (join (first (filter #(prime? (as-int %))
                      (lazy-cat (permutations s)
                                [(euler041alt (rest s))])))))
 
;; (1+2+3+4+5+6+7+8+9=45 => always dividable by 3) 
;; (1+2+3+4+5+6+7+8=36 => always dividable by 3) 
;; So n = 7 is the maximum 
;; http://mathworld.wolfram.com/DivisibilityTests.html
(time (println (euler041alt "7654321")))

