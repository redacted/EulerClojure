
(defn euler052 [n] 
  (if (apply = (map #(sort (str (* n %))) [1 2 3 4 5 6]))
    n
    (recur (inc n))))

(time (println (euler052 100000)))

