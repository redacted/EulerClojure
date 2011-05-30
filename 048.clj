(use '[clojure.contrib.math :only (expt)])

(defn last-ten [n]
  (BigInteger. (apply str (reverse
          (take 10 (reverse (str n))))))

(defn euler-48 []
  (let [d (reduce + (map #(expt % %) (range 1 1001)))]
    (last-ten d)))

(time (println (euler-48)))
