(defn factorial [x]
  (apply * (range 2 (inc x))))

(defn choose [a b]
  "a choose b"
  (/ (factorial a) (* (factorial b) (factorial (- a b))))) 

; choosing 20 possible path segments out of 40 possible path segments
; search "monotonic paths" n path on n*n grid
(defn euler015 [grid]
  (choose (* 2 grid) grid))

(println (euler015 20))
