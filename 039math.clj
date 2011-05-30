(defn pythagorean-triple [m n k]
  "Uses Eulcid's formula to generate pythagorean triples."
  (map #(* k %) [(- (* m m) (* n n)) (* 2 m n) (+ (* m m) (* n n))]))

(defn pythagorean-perimeters [p]
  (let [sq (int (Math/sqrt p))]
    (set
          (for [n (range 1 sq)
                m (range (inc n) sq)
                k (range 1 (/ p (+ (* m m) (* n n))))
                t [(sort (pythagorean-triple m n k))]
                :when (>= p (apply + t))]
            t))))

(defn euler039 [upper]
  (let [h (frequencies (map #(apply + %) (pythagorean-perimeters upper)))]
    (key (first (sort-by val > h)))))


(time (println (euler039 1000))) ;; "Elapsed time: 33.017842 msecs"

