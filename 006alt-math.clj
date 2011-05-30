
;; use the mathematical sums
(defn euler006 [^Integer n]
  (let 
    [square-of-sum (Math/pow (* 0.5 n (- n 1)) 2)
     sum-of-squares (/ (* n (+ n 1) (+ (* 2 n) 1)) 6 )]

      (- square-of-sum sum-of-squares)))

(time (println (euler006 100)))

