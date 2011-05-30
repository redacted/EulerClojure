;; 2-variable quadratic || diphoantine equation
;; parameters for next-n next-b from online solver
;; http://www.alpertron.com.ar/QUAD.HTM

(defn next-b [b n]
  (- ( + (* 3 b) (* 2 n)) 2))

(defn next-n [b n]
  (- ( + (* 4 b) (* 3 n)) 3))     

(defn euler100 []
  (loop [b 85, n 120]
    (if (< 1e12 n)
      b
      (recur (next-b b n) (next-n b n)))))

(time (println (euler100)))
