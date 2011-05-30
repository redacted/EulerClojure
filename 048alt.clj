(use '[clojure.contrib.math :only (expt)])

(time (println (apply str (reverse (take 10 (reverse (str (reduce + (map #(expt % %) (range 1 1001))))))))))

