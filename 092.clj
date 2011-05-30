
(def square-chars {\0 0 \1 1 \2 4 \3 9 \4 16 \5 25 \6 36 \7 49 \8 64 \9 81 }) 

(defn next-number [n]
  (let [s (str n)]
    (reduce + (map square-chars s))))

(defn ends-in-89? [n]
  (cond
    (= 1 n) nil
    (= 89 n) true
    :else (recur (next-number n))))

(defn euler092 [limit]
  (count (filter true? (pmap ends-in-89? (range 1 (inc limit))))))

(time (println (euler092 10000000)))

(shutdown-agents)
