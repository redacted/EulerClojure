(use '[clojure.contrib.math :only (abs)])

(def pentagonal-nums
  ;; use fast bit-shifts for speed up
  ;; (map #(bit-shift-right (* % (dec (* 3 %))) 1) (iterate inc 1)))
  (map (fn [n] (/ (* n (- (* 3 n) 1)) 2)) (iterate inc 1)))

(defn pentagonal? [n]
  ;; nicer test that int coercion
  (zero? (rem (+ 1 (Math/sqrt (+ 1 (* 24 n)))) 6)))

(defn pent-sum-diff? [a b]
  (and (pentagonal? (abs (- b a)))
       (pentagonal? (+ b a))))

(defn euler044 []
  (first (for [a pentagonal-nums
               b (take-while #(< % a) pentagonal-nums)
               :when (pent-sum-diff? a b)]
           [a b (abs (- a b))])))

(time (println (euler044)))

