(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prime? [n]
  (if (> 2 n)
    false
    (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))  

(defn gen-quadratics [a b]
  (map (fn [n] (+ (* n n) (* a n) b)) (iterate inc 0)))

(defn euler027 []
  (let [quads (for [a (range -1000 1000)
                    ;; b must be prime to return a prime when n == 0
                    b (take-while #(< % 1000) primes)]
                [a b (count (take-while #(and (> % 0) (prime? %)) (gen-quadratics a b)))])
        ;; [a b _] (first (sort-by last > quads))]    
        [a b _] (reduce #(if (> (nth %1 2) (nth %2 2)) %1 %2) quads)]
    (* a b)))

(time (println (euler027)))
