(use '[clojure.string :only (split-lines)])

(defn process-line [line]
  (map #(Integer/parseInt %) (re-seq #"\w+" line)))   

(def triangle (map #(process-line %) (split-lines (slurp "triangle.txt"))))

;; (partition 2 1 a) splits a into len(a) - 1 two element tuples.
;; take the max of each tuple.
;; b is the next row of the triangle, and len(b) = len(a) - 1
;; merge the (max (partition a) with b, and repeat by partioning etc the result
;; and merging into the next row
(defn merge-rows[a b]
  (map + (map #(apply max %) (partition 2 1 a)) b))

(time (println (reduce merge-rows (reverse triangle))))

