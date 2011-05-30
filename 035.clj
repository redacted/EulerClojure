(use '[clojure.contrib.lazy-seqs :only (primes)])
(use '[clojure.string :only (join)])


(defn prime? [s]
  (let [n (Integer/parseInt s)]
  (if (> 2 n)
    false
    (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes)))))


(defn rotations [s]
  (let [l (count s)]
    (map join (take l (partition l 1 (cycle s))))))

(defn euler035 [target]
  (let [under-million (map str (take-while #(< % target ) primes))
        under-mill-rot (filter #(every? prime? %) (map rotations under-million))]
    (count (distinct (flatten under-mill-rot)))))

(time (println (euler035 1000000)))



