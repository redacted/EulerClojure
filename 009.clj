; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

(defn pythagorean? [a b c]
  (and (< a b c) (== (+ (* a a) (* b b)) (* c c))))

(defn euler009 []
  (let [limit 1000]
    (first (for [a (range 1 limit)
                 b (range a limit)
                 c [(max 0 (- limit a b))] 
                 :when (pythagorean? a b c)]
             (bigint (* a b c))))))

(time (println (euler009)))
