(defn fact [x]
  (apply * (range 2 (inc x))))

(def factorial (memoize fact))

(defn choose [a b]
  "a choose b"
  (/ (factorial a) (* (factorial b) (factorial (- a b))))) 

(defn euler053 [upper]
  (let [choosings 
        (for [a (range 23 upper)
                        b (range 1 a)] (choose a b))]
    (count (filter #(< 1000000 %) choosings))))

(time (println (euler053 101)))
