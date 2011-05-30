(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn prime? [n]
  (if (> 2 n)
    false
    (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))

(defn as-digits [num]
  (map #(Character/getNumericValue %) (str num)))

(defn as-int [coll]
  (Integer/parseInt (apply str coll)))

(defn lr-truncatable-prime? [n]
  (let [trunc-prime? (fn [f n]
                       (cond
                         (< n 10) (prime? n)
                         ;; recur with the same function and the 
                         ;; result of applying the function
                         (prime? n) (recur f (as-int (f (as-digits n))))
                         true false))]

    (and (trunc-prime? butlast n)     ; from right
         (trunc-prime? rest n))))     ; from left

(defn euler037 []
  (reduce + (take 11 (filter lr-truncatable-prime? (iterate inc 10)))))


(time (println (euler037)))
