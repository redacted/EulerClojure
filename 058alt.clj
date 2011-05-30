;; update the running totals rather than recomputing everything

(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prime? [n]
  (and (< 1 n)
       (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))

(defn euler-58-loop []
  (let [corners (fn [n] (take 4 (iterate #(- % (dec n)) (* n n))))]
    (loop [n 3 trues 0 falses 1]
      (let [c (count (filter prime? (corners n)))
            ts (+ trues c)
            fs (+ falses (- 4 c))]
        (if (> 1/10 (/ ts (+ ts fs)))
          n
          (recur (+ n 2) ts fs))))))

(time (println (euler-58-loop)))

