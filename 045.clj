;; solve using inverse functions
(defn pentagonal? [t]
  (let [n (/ (+ (Math/sqrt (+ (* 24 t) 1)) 1) 6)]
    (== n (int n))))    

;; all hexagonal numbers are triangular
(defn hexagonal [n]
  (* n (- (* 2 n) 1)))  

(defn euler045 []
  (first (filter pentagonal? (map hexagonal (iterate inc 144)))))

(time (println (euler045)))
