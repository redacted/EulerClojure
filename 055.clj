
(defn palindrome? [s]
  (let [s_ (str s)]
    (= (reverse s_) (seq s_))))   

(defn add-reversed [num]
  (+ num (bigint (apply str (reverse (str num))))))

(defn euler055 []
  (loop [coll (range 1 10000)
         counter 1]
    (let [palin-coll (remove palindrome? (map add-reversed coll))]
      (if (= 50 counter)
        (count palin-coll)
        (recur palin-coll (inc counter))))))


(time (println (euler055)))
