
(defn fib-seq []
  ((fn rfib [a b] 
       (cons a (lazy-seq (rfib b (+ a b)))))
    0 1))

(defn str-length [n]
  (.length (str n)))

(defn indexed [coll] 
  (map vector (iterate inc 0) coll)) 

(defn euler025 [target]
  (first (filter #(>= (str-length (% 1)) target) (indexed (fib-seq)))))

(time (println (euler025 1000)))

