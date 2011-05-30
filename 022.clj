(use '[clojure.string :only (split-lines)])         

(def names (sort (split-lines (slurp "names.txt"))))

(defn char-to-int [c]
  (- (int c) 64))

(defn name-total [s]
  (reduce + (map #(char-to-int % ) s)))

(defn indexed [coll] 
  (map vector (iterate inc 1) coll))

(def name-values (indexed (map #(name-total %) names)))

(defn euler022 []
  (reduce + (map #(* (% 0) (% 1)) name-values)))

(time (println (euler022)))

