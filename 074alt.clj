;; same fairly naive algorithm, but noticing that
;; ordering of digits doesn't matter
;; i.e., (next-number 12345) == (next-number 54321)
;; distinct sorted-ints: 1000000 -> 8001
;; frequencies gives [a b], sum b's where a matches

(defn factorial [x]
  (apply * (range 2 (inc x))))

(defn sorted-int [n]
  (Integer/parseInt (apply str (reverse (sort (str n))))))

(def fact-map
  (apply hash-map 
         (interleave (seq "0123456789") 
                     (map #(factorial %) (range 10)))))  

(defn next-number [n]
  (reduce + (map #(fact-map %) (str n))))

(defn cycle-length [n_]
  (let [accum []]
    (loop [n n_, coll accum ]
      (let [next-coll (conj coll n)
            next-n (next-number n)]
      (if (some #(= next-n %) next-coll)
        (count next-coll)
        (recur next-n next-coll))))))

(defn euler074 [n]
  (let [test-numbers (frequencies (map sorted-int (range 1000000)))]
  (reduce + (for [[a b] test-numbers
                  :when (= n (cycle-length a))]
               b))))



(time (println (euler074 60)))
