(defn palindromic? [n]
  (= (seq (str n)) (reverse (str n))))

(defn next-lychrel [n]
  (+ n (bigint (apply str (reverse (str n))))))

(defn lychrel? [n]
  {:pre [(< n 10000)]} ;; only numbers < 10000 converge in <50 iterations
  (not-any? palindromic? (take 50 (rest (iterate next-lychrel n)))))

(defn euler-55 []
  (count (filter lychrel? (range 1 10000))))

(time (println (euler-55)))
