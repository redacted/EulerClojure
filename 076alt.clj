;; http://www.research.att.com/~njas/sequences/A008284
;; http://en.wikipedia.org/wiki/Bell_number#Triangle_scheme_for_calculating_Bell_numbers

(use '[clojure.contrib.math]
     '[clojure.contrib.def :only (defn-memo)])

(defn tnk [n k]
  (cond
    (= 1 k) 1
    (= n k) 1
    (> k n) 0
    :else (+ (tnk (dec n) (dec k)) (tnk (- n k) k))))

(defn euler076 []
  (reduce + (map #(tnk 100 %) (range 1 100))))

(time (println (euler076)))

