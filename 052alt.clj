
(time (println (first (filter (fn [n] (apply = (map (fn [m] (sort (str (* n m)))) [1 2 3 4 5 6]))) (iterate inc 100000)))))




