
(defn as-int [coll] (bigint (apply str coll)))

(defn same-length? [coll] 
  (apply = (map #(count (str %)) coll)))     

(def cube-map
  (let [cubes (take 10000 (map #(* % % %) (iterate inc 1)))]
    (reduce
      (fn [m cube]
        (let [normcube (bigint (apply str (sort (str cube))))]
          (assoc m normcube (conj (m normcube #{}) cube))))
      {}
      cubes)))

(defn euler062 []
  (let [poss-five-cubes (filter #(= 5 (count (val %))) cube-map)
        match (first (filter #(same-length? (val %)) poss-five-cubes))]
    (first (sort (val match)))))

(time (println (euler062)))

