(defn pythagorean? [a b c]
  (== (+ (* a a) (* b b)) (* c c)))

(defn perimeters []
  (let [limit 1001]
    (frequencies
      (for [p (range 10 limit)
            a (range 1 (/ p 2))
            b (range a (/ p 2))
            c [(max 0 (- p a b))] 
            :when (pythagorean? a b c)]
        (+ a b c)))))  

(defn euler039 []
  (let [pers (perimeters)]
    (first (sort-by val > pers))))

(time (println (euler039)))
