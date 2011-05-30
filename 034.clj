(defn factorial [x]
  (apply * (range 2 (inc x))))

(def fact-map
  (apply hash-map (interleave (seq "0123456789")
                                          (map #(factorial %) (range 10)))))

(defn fact-equal? [s]
  (let [factsum (reduce + (map #(fact-map %) s))]
    (= (str factsum) s)))

(defn euler034 []
  ;; 50000 upper bound found by inspection :)
  ;; could also use 9999999 as 7*9! < 9999999
  ;; http://mathworld.wolfram.com/Factorion.html
  (reduce + (filter #(fact-equal? (str %)) (range 3 50000))))

(time (println (euler034)))
