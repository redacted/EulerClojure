(defn euler071 [limit]
  ;; biggest multiple of 7 for the denominator 
  (let [denom (* (quot limit 7) 7)]
    (last (sort (distinct (for [a (range 1 denom)
                                :when (< (/ a denom) 3/7)]
                            (/ a denom)))))))

(time (println (euler071 1000000)))
