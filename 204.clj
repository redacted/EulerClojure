(def primes [ 2 3 5 7 11 13 
             17 19 23 29 31 
             37 41 43 47 53 
             59 61 67 71 73 
             79 83 89 97])

(defn smerge [xs ys]
  (lazy-seq
    (let [x (first xs),
          y (first ys),
          [z xs* ys*]
          (cond
            (< x y) [x (rest xs) ys]
            (> x y) [y xs (rest ys)]
            :else   [x (rest xs) (rest ys)])]
      (cons z (smerge xs* ys*)))))
 
(defn smergeN [coll]
  (if (= 2 (count coll))
    (smerge (first coll) (second coll))
    (smerge (first coll) (smergeN (rest coll)))))
 
(defn map*n [n ks] (map #(* n %) ks))
 
(def hamming
  (lazy-seq
    (cons 1 (smergeN (pmap #(map*n % hamming) primes)))))

(defn euler204 []
  (count (take-while #(<= % 1e9) hamming)))

(time (println (euler204)))

(shutdown-agents)
