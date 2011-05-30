(use '[clojure.contrib.lazy-seqs :only (primes)]
     '[clojure.contrib.math :only (expt)])

(defn as-int [coll] (Integer/parseInt (apply str coll)))

(defn prime? [n]
  (and (< 1 n)
       (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes)))) 

(defn n-digit-masks
  "Returns all n-digit binary numbers as strings."
  [n]
  (map #(rest (Integer/toBinaryString (bit-or (bit-shift-left 1 n) %)))
       (range (expt 2 n))))

(defn apply-mask
  "Replaces digits of p with value n according to nonzero locations in mask m."
  [m p n]
  (map #(if (= \0 %1) %2 n) m p))

(defn euler051 [family]
  (first
   (for [p (map str primes)
         d [(count p)]
         m (rest (butlast (n-digit-masks d)))
         f [(filter #(prime? (as-int %))
                    (map #(apply-mask m p %) "0123456789"))]
         g [(filter #(not (= \0 (first %))) f)]
         :when (<= family (count g))]
     (map #(apply str %) g))))

(time (println (euler051 8)))

