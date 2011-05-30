;;  Here’s the breakdown:
;;  has-special-triple? checks to see that given a sorted list of numbers,
;;  there are three numbers that are spaced evenly apart. 
;;  euler-49 generates primes in the right range,
;;  makes lists of permutations of each prime, 
;;  makes sure the permutations are prime and four digits long 
;;  (because a 0 in the leading position counts as 3 digits), 
;;  and then returns all groups that satisfy the has-special-triple? property.

(use '[clojure.contrib.combinatorics :only (permutations)]
     '[clojure.contrib.lazy-seqs :only (primes)])

(defn prime? [n]
  (and (< 1 n)
       (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes)))) 

(defn as-int [coll] (Integer/parseInt (apply str coll)))

(defn choose-k
  "Returns all possible unique groups of size k in coll."
  [coll k]
  (let [n (count coll)]
    (if (<= k 1)
      (map vector coll)
      (reduce into []
              (for [i (range 1 (inc n))]
                (map #(into [(nth coll (dec i))] %)
                     (choose-k (drop i coll) (dec k))))))))

(defn has-special-triple? [coll]
  (let [fs (frequencies (map (fn [[a b]] (- b a)) (choose-k coll 2)))]
    (first (for [d (filter #(= 2 (fs %)) (keys fs))
                 a coll
                 :when (some #(= % (+ a d)) coll)
                 :when (some #(= % (+ a d d)) coll)]
             [a (+ a d) (+ a d d)]))))

(defn euler-49 []
  (let [ps (take-while #(> 10000 %) (drop-while #(> 1000 %) primes ))
        p2q (fn [p] (filter #(and (<= 1000 %) (prime? %))
                            (map as-int (distinct (permutations (str p))))))
        qs (distinct (map #(sort (p2q %)) ps))]
    (remove nil? (map has-special-triple? qs))))

(time (println (euler-49)))
