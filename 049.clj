(use '[clojure.contrib.lazy-seqs :only (primes)])
(use 'clojure.contrib.combinatorics)
(use '[clojure.contrib.math :only (abs)])

(defn prime? [n]
    (if (> 2 n)
      false
      (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))

(defn as-int [coll] (Integer/parseInt (apply str coll)))

(defn primes-permuted [prime]
  (sort (distinct (filter #(and (prime? %) (<= 1000 %)) 
                    (map as-int (permutations (str prime)))))))

(defn progression? [coll start step]
  (and (some #(= (+ start step) %) coll)
       (some #(= (+ start step step) %) coll)))

(defn euler049 []
  (let [prime-permutations 
        (distinct (map primes-permuted 
                       (take-while #(< % 10000) 
                                   (drop-while #(< 1000 %) primes))))]
    (for [a prime-permutations
          b a
          c (range 1000 (- 10000 b b))
          :when (progression? a b c)]
      [b (+ b c) (+ b c c)])))

(time (println (euler049)))
