;; log is monotonically increasing
;; log(a^x) == x*log(a)
;; therefore we can solve this by replacing (expt a b) with (* b (Math/log a))
;; and sorting
(use '[clojure.string :only (split-lines)])

(defn process-line [line]
  (map #(Integer/parseInt %) (re-seq #"\w+" line)))   

(def base-exp-pairs 
  (zipmap (map #(process-line %) (split-lines (slurp "base_exp.txt"))) 
          (range 1 1001)))

(defn euler099 []
  (second (first (sort-by first > 
                       (for [[[a b] c] base-exp-pairs]
                         [(* b (Math/log a)) c])))))

(time (println (euler099)))
