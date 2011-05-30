(def sqrt2-approx (iterate #(/ (+ (numerator %) (* 2 (denominator %)))
                               (+ (numerator %) (denominator %))) 
                           3/2))

(defn numerous-numerator? [n]
  (> (count (str (numerator n)))
     (count (str (denominator n)))))

(defn euler057 [limit]
  (count (filter numerous-numerator? 
                 (take limit sqrt2-approx))))

(time (println (euler057 1000)))
