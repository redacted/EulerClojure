; alternate, much slower version - highlights lazy-seqs for primes though

(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prime-factors-of [n]
  (filter #(zero? (rem n %)) (take-while #(> n (* % %)) primes)))

(time (println (reduce max (prime-factors-of 600851475143))))

