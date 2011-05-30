
(defn euler006 [n]
  (let 
    [numbers (range 1 (inc n))
    square-of-sum (Math/pow (reduce + numbers) 2)
    sum-of-squares (reduce + (map #(Math/pow % 2) numbers))]

      (- square-of-sum sum-of-squares)))

(time (println (euler006 100)))

