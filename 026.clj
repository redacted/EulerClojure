;; http://mathworld.wolfram.com/DecimalExpansion.html explains the maths
;; Break each number n down to 2**a * 5**b * n0.
;; The multiplicative order of 10 mod n0 is the number of recurring digits.

;; calculate the multiplicative order of a modulo n
(defn order [a n]
  ;; modpow: java function on BgIntegers, (.modpow a e n) -> a^e mod n
  (first (filter #(= 1 (.modPow (bigint a) % (bigint n)))
                 (map bigint (iterate inc 1)))))

;; remove factors of 2 and 5 and find the multiplicative order
(defn decimal-period [n]
  (cond (= 1 n) 0
        (zero? (rem n 2)) (decimal-period (/ n 2))
        (zero? (rem n 5)) (decimal-period (/ n 5))
        true (order 10 n)))

(defn euler026 [n]
  (let [nums (range 1 n)
        periods (map decimal-period nums)]
    ;; zipmap returns a map with periods as keys and nums as vals
    ;; then picks the max period -> nice solution
    ((zipmap periods nums) (apply max periods))))

(time (println (euler026 1000)))
