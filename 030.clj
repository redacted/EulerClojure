(use 'clojure.contrib.math)

(defn sum-of-digits [s]
  (reduce + (map #(expt (Integer/parseInt (str %)) 5) (seq s))))

(defn matches? [s]
  (= (str (sum-of-digits s)) s))

(time (println (reduce + (filter #(matches? (str %)) (range 10 400000)))))
