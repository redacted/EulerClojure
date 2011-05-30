;; optimize - we do a lot of n^5, n 0..9
;; so put the results in a hashmap

(defn euler030 []
  (let [ pow5 (apply hash-map (interleave (seq "0123456789")
                                          (map #(Math/pow % 5) (range 10))))
        maxn (* (pow5 \9) 6)]
    (reduce + (filter #(= % (reduce + (map pow5 (str %)))) (range 2 maxn)))))

(time (println (euler030)))
