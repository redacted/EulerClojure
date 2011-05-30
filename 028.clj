;; Mathematical approach
;; corners given by n^2, n^2 - n + 1, n^2 - 2n + 2, n^2 -3n + n
;; Therefore the total for each ring/square is 4n^2 - 6n - 6

(defn euler028 [n]
  (reduce + 1 (map #(- (* 4 % %) (* 6 %) 6) (range 3 n 2))))

(time (println (euler028 1001)))

