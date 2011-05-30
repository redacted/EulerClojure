(use 'clojure.contrib.math)

(defn as-digits-sum [num]
  (reduce + (map #(Character/getNumericValue %) (str num))))

(defn euler050 [upper]
  (reduce max (for [a (range upper)
                    b (range upper)]
                (as-digits-sum (expt a b)))))

(time (println (euler050 100)))
