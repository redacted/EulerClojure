(def fractions 
  (for [a (range 10 99)
        b (range (inc a) 100) :when (not (or (zero? (rem a 10)) (zero? (rem b 10))))]
    [a b (/ a b)]))

(defn curious? [frac]
  (let [[a b c] frac
        aq (quot a 10)
        bq (quot b 10) 
        ar (rem  a 10)
        br (rem  b 10)]

    (or 
      (and (= ar br) (= (/ aq bq) c))
      (and (= aq bq) (= (/ ar br) c))  
      (and (= aq br) (= (/ ar bq) c))
      (and (= ar bq) (= (/ aq br) c)))))


(defn euler033 []
  (reduce * (map last (filter curious? fractions))))

(time (println (euler033)))
