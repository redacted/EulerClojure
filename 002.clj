; we want to sum all the even value terms in the Fibonacci sequence
;   that are less than 4e6

(def fibo (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(println (reduce + (filter even? (take-while #(> 4000000 %) fibo))))


