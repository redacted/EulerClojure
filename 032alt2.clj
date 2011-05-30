(use '[clojure.string :only (join)])

(defn pandigital? [n]
  (let [s (map #(Integer/parseInt (str %)) (seq (str n)))]
    (and (not (some zero? s))
         (= 9 (count s) (count (distinct s))))))

;(def possibilities
  ;(concat (for [a (range 1 10) b (range 10 10000)] [a b (* a b)]) ;; [1] * [4] = [5]
          ;(for [a (range 10 100) b (range 100 1000)] [a b (* a b)]))) ;; [2] * [3] = [5]

(defn euler032 []
  (reduce + (distinct (for [a (range 2 5000)
        b (range a (quot 9999 a))
        :let [c (* a b)] :when (pandigital? (str a b c))] 
    c ))))



(time (println (euler032)))
