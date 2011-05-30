; sums those numbers under 1000 that are divisible by 3 or 5
; #() is an anonymous function
; list is defined by (range x y) = [x, y)

(defn multiple-of-3-or-5? [n]
  (or (zero? (rem n 3))
      (zero? (rem n 5))))

(defn euler001 []
  (reduce + (filter multiple-of-3-or-5? (range 1000))))

(time (println (euler001)))

