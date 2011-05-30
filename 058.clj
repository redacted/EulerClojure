;; Mathematical approach
;; corners given by n^2, n^2 - n + 1, n^2 - 2n + 2, n^2 -3n + n

(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prime? [n]
  (if (> 2 n)
    false
    (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))

(def memo-prime? (memoize prime?))

(defn prime-corners [n]
  (let [n2 (* n n)]
    (count (filter memo-prime? [(- (+ n2 1) (* 1 n)) 
                                (- (+ n2 2) (* 2 n)) 
                                (- (+ n2 3) (* 3 n))]))))

(def memo-corners (memoize prime-corners))

(defn frac-prime-corners [n]
  (/ (reduce + (map memo-corners (range 3 (inc n) 2))) (+ n (dec n))))

(defn euler058 []
  (let [numbers (iterate #(+ 2 %) 3)]
    (first (filter #(< (frac-prime-corners %) 1/10) numbers))))

(time (println (euler058)))

