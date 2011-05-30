(defn factorial [x]
  (apply * (range 2 (inc x))))

(defn euler020 [target]
  (reduce + (map #(Integer/parseInt (str %)) (str (factorial target))))) 

(println (euler020 100))

