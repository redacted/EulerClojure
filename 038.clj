
(defn pandigital-9? [a]
  (= "123456789" (apply str (sort (rest (.split (str a) ""))))))

(defn as-int [coll] 
  (Integer/parseInt (apply str coll))) 

(defn concat-mult [n upper]
  (apply str (map #(* n %) (range 1 (inc upper)))))

(defn euler038 []
  (reduce max (for [a (range 1 10000)
                    b (range 2 10)
                    c [(concat-mult a b)]
                    :when (= 9 (count c))
                    :when (pandigital-9? c)]
                (as-int c))))

(time (println (euler038)))





