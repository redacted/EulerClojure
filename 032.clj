(use '[clojure.string :only (join)])

(defn pandigital? [n l]
  (let [s (map #(Integer/parseInt (str %)) (seq (str n)))]
    (and (not (some zero? s))
         (= l (count s) (count (distinct s))))))

(def possibilities
  (concat (for [a (range 2 5000) 
                b (range a (quot 9999 a))] 
            [a b (* a b)]))) ;; [1] * [4] = [5]


(defn euler032 []
  (let [pandigits (for [d possibilities :when (pandigital? (join "" d) 9 )] d)
        uniq-pd (distinct (map last pandigits))]
    (reduce +  uniq-pd)))


(time (println (euler032)))
