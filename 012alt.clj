(def triangle-nums (map first (iterate (fn [[n m]] [(+ n m) (+ m 1)]) [1 2])))

(defn prime-factors-of [num]
  "Returns a sorted list of prime factors of num, including multiplicity."
  (let [q (Math/sqrt num)
        factor? (fn [nom den] (zero? (rem nom den)))]
    (loop [n num
           d 2
           r []]
      (cond
       (> d q) (concat r [n])
       (= n d) (concat r [n])
       (factor? n d) (recur (/ n d) d (conj r d))
       true          (recur n (inc d) r)))))

(defn num-divisors-slow [n]
  (+ 1 (count (filter zero? (map #(mod n %) (range 1 (+ 1 (/ n 2))))))))

(defn euler-12-slow [divisors]
  (first (drop-while #(> divisors (num-divisors-slow %)) triangle-nums)))

(defn num-divisors-fast [num]
  (let [freqs (reduce #(assoc %1 %2 (inc (get %1 %2 0)))
                      {} (prime-factors-of num))]
    (reduce #(* %1 (inc %2)) 1 (vals freqs))))

(defn euler-12-fast [divisors]
  (first (drop-while #(> divisors (num-divisors-fast %)) triangle-nums)))


(time (println (euler-12-fast 500)))
