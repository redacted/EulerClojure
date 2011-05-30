; What is the value of the first triangle number to have over five hundred divisors?

(use 'clojure.contrib.math)

; lazy list of all triangular numbers
(def triangles
    (cons 0 (map + triangles (iterate inc 1))))

(defn num_divisors [n]
  (* 2 (count (filter #(zero? (mod n %)) (range 1 (sqrt n))))))

(defn euler012 []
  (first (filter #( > (num_divisors %) 500) triangles)))

(time (println (euler012)))
