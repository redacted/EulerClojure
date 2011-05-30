(defn factorial [x]
  (apply * (range 2 (inc x))))

(def fact-map
  (apply hash-map (interleave (seq "0123456789")
                                          (map #(factorial %) (range 10)))))  
(defn next-number [n]
  (reduce + (map #(fact-map %) (str n))))

(def next-memo (memoize next-number))

(defn cycle-length [n_]
  (let [accum []]
    (loop [n n_, coll accum ]
      (let [next-coll (conj coll n)
            next-n (next-memo n)]
      (if (some #(= next-n %) next-coll)
        (count next-coll)
        (recur next-n next-coll))))))

(defn euler074 []
  (count (filter #(= 60 %) (pmap cycle-length (range 1 1000000)))))

(time (println (euler074)))

(shutdown-agents)
