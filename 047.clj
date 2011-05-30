(defn prime-factors
  ([n] (prime-factors [] n 2))
  ([factors n candidate]
   (cond
     (= n 1) factors
     (= 0 (rem n candidate)) (recur (conj factors candidate) (quot n candidate) candidate)
     (> candidate (Math/sqrt n)) (conj factors n)
     :else (recur factors n (inc candidate)))))

(defn distinct-factors [n]
  (count (distinct (prime-factors n))))

(defn sequential-n? [coll n]
  (let [a (first coll)]
    (= (range a (+ a n)) coll))) 

(defn euler047 [target]
  (let [quadruplets (partition target 1 (filter #(= target (distinct-factors %)) (iterate inc 1)))] 
    (first (filter #(sequential-n? % target) quadruplets))))

(time (println (euler047 4)))


