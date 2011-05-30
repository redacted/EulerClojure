(use '[clojure.string :only (join)])   

(def fraction-string (join (take 200000 (iterate inc 1))))

(defn euler040 []
   (reduce * (map #(Character/getNumericValue (nth fraction-string (dec %))) 
                  [1 10 100 1000 10000 100000 1000000])))

(time (println (euler040)))
