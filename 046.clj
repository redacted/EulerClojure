(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prime? [n]
  (if (> 2 n)
    false
    (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))

(def composite-numbers
  (filter #(not (prime? %)) (iterate #(+ 2 %) 11)))

(defn is-square? [n]
  (zero? (rem (Math/sqrt (/ n 2)) 1)))

(defn euler046 []
  (first (for [c composite-numbers
               b [(take-while #(< % c) primes)]
               d [(map #(- c %) b)]
               :when (not-any? is-square? d)]
    c)))

(time (println (euler046)))



