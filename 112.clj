
(defn bouncy? [n]
  (let [s (str n)]
      (if (and (not (= (sort s) (seq s)))
               (not (= (reverse (sort s)) (seq s))))
        1 0)))


(defn euler112 []
  (loop [n 1 bouncy 0]
    (if (= 99/100 (/ bouncy n))
      n
      (recur (inc n) (+ bouncy (bouncy? (inc n)))))))

(time (println (euler112)))
