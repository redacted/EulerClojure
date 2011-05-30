(use '[clojure.contrib.lazy-seqs :only (primes)])         
(defn prime? [n]
  (if (> 2 n)
    false
    (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))

(defn make-seq-accumulator [seq]
  (map first (iterate (fn [[sum s]]
                        [(+ sum (first s)) (next s)])
                      [(first seq) (rest seq)])))

(def prime-sums (conj (make-seq-accumulator primes) 0))

(defn euler050 [target]
  (loop [c 1]
    (let [bots (reverse (take c prime-sums))
          tops (take c (reverse (take-while #(> target (- % (last bots)))
                                            (rest prime-sums))))]
      (if-let [v (some #(if (prime? %) % )
                       (map #(- %1 %2) tops bots))]
        v
        (recur (inc c))))))

(time (println (euler050 1000000)))
