(use 'clojure.contrib.combinatorics)

(defn as-int [coll] 
  (Integer/parseInt (apply str coll)))       

(defn all-mods? [coll]
  (every? true? 
          (map #(zero? (rem %1 %2))
               (map as-int (partition 3 1 (rest coll)))
               [2 3 5 7 11 13 17])))
  

(defn euler044 []
   (reduce + 
           (map #(BigInteger. (apply str %)) 
                (filter all-mods? 
                        (permutations [0 9 8 7 6 5 4 3 2 1])))))

(time (println (euler044)))
