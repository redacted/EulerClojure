(use 'clojure.contrib.math)
(defn euler029 [n]
  (let [upper (inc n)]
    (for [a (range 2 upper)
          b (range 2 upper)]
      (expt a b))))

(time (println (count (distinct (euler029 100)))))
