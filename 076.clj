;; modified version of 031.clj (bibi's algorithm)

(def coins (range 99 0 -1))
 
(defn change[c v]
  (let [f (first c)]
    (if (= f 1) 1
      (reduce + (for [n (range 0 (inc (quot v f)))]
                  (change (rest c) (- v (* n f))))))))
 
(time (println (change coins 100)))

