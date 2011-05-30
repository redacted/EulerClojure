(use '[clojure.contrib.lazy-seqs :only (primes)]) 
(use '[clojure.contrib.seq-utils :only (rotations)])

(defn prime? [n]
  (if (> 2 n)
    false
    (not-any? #(zero? (rem n %)) (take-while #(<= (* % %) n) primes))))  

(defn circular-prime? [n]
  (every? prime? (map #(Integer/parseInt (apply str %)) (rotations (str n)))))

(defn euler035 []
  (count (filter circular-prime? (take-while #(< % 1000000) primes))))

(time (println (euler035)))

