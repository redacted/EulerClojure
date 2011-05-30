(use 'clojure.contrib.math)

(defn num-to-vec [number]
  (map #(Integer/parseInt (str %)) (str number)))

(defn euler016 [number]
  (apply + (num-to-vec number)))

(time (println (euler016 (expt 2 1000))))
