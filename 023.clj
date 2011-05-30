(use 'clojure.set)
 
(defn sum-divisors [n]
  (let [limit (Math/sqrt n)]
    (loop [i 2
       sum 1]
      (cond
       (= i limit) (+ i sum)
       (> i limit) sum
       (zero? (rem n i)) (recur (inc i) (+ sum i (/ n i)))
       true              (recur (inc i) sum)))))
 
(defn abundant? [n]
  (> (sum-divisors n) n))
 

(defn sum-of-abundants? [i abundants]
  (some (fn [a] (abundants (- i a))) abundants))
 
(defn problem23-v2 []
  (let [abundants (into (sorted-set) (filter abundant? (range 12 28112)))]
    (apply + (for [i (range 1 28124)
                   :when (not (sum-of-abundants? i abundants))]
               i))))

(time (println (problem23-v2)))
