;; the first step on a n-digit number collapses the search to (* 9 9 n)
;; precalculating this is an easy optimization

(def square-chars {\0 0 \1 1 \2 4 \3 9 \4 16 \5 25 \6 36 \7 49 \8 64 \9 81 }) 

(defn as-int [coll] (Integer/parseInt (apply str coll)))

(defn next-number [n]
    (reduce + (map square-chars (str n))))

(defn ends-in-89? [n]
  (cond
    (zero? n) nil
    (= 1 n) nil
    (= 89 n) true
    :else (recur (next-number n))))

(defn euler092 [limit]
  (let [first-stage (zipmap (range 1 568) (map ends-in-89? (range 1 568)))
        one-cycle-all (map next-number (range 1 (inc limit)))]
    (count (filter true? (map #(first-stage %) one-cycle-all)))))


(time (println (euler092 10000000)))
   
