;; We can massively reduce the search space by noting that the order of the 
;; digits doesn't affect the chain end -> if ABC ends in 89, so does CBA etc
;;
;; Therefore we can simply generate all numbers ABCDEFG where 
;; A <= B <= C <= D <= E <= F <= G and test them. For every passing number
;; use the multinomial coefficient to see how many permutations also pass.

(def square-chars {\0 0 \1 1 \2 4 \3 9 \4 16 \5 25 \6 36 \7 49 \8 64 \9 81 }) 

(defn factorial [x]
  (apply * (range 2 (inc x))))

(defn multinomial-coeff [n]
  (let [coll (vals (frequencies (str n)))]
    (/ (factorial (reduce + coll)) (reduce * (map factorial coll)))))

(defn as-int [coll] (Integer/parseInt (apply str coll)))

(defn next-number [n]
  (reduce + (map square-chars (str n))))

(defn ends-in-89? [n]
  (cond
    (zero? n) nil
    (= 1 n) nil
    (= 89 n) true
    :else (recur (next-number n))))

(defn euler092 []
  (let [numbers-to-test (for [a (range 0 10)
                              b (range a 10)
                              c (range b 10)
                              d (range c 10)
                              e (range d 10)
                              f (range e 10)
                              g (range f 10)]
                          ;; reverse to handle leading zeros
                          (as-int [g f e d c b a])) 
        correct (filter ends-in-89? numbers-to-test)]
    (reduce + (map multinomial-coeff correct))))

(time (println (euler092)))
