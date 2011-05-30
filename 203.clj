(use '[clojure.contrib.lazy-seqs :only (primes)])

(def square-primes (map #(* % %) primes))

(defn squarefree? [n]
  (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) square-primes)))

(defn nextrow [row]  ;; generate next row of a pascal's triangle
  (vec (concat [1] (map #(apply + %) (partition 2 1 row)) [1] )))

(defn euler203 [n]
  (reduce + (filter squarefree? 
                    (distinct (flatten (take n (iterate nextrow [1])))))))

(time (println (euler203 51)))

