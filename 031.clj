(def coins [200 100 50 20 10 5 2 1])

(defn coin-combos [sum goal maxcoin]
  ;; the only valid coins are those less than the maxcoin, and those 
  ;; that wouldn't increase the sum past the goal
  ;; ID the valid coins at each stage and recurse with them
  (let [valid-coins (filter #(and (<= % maxcoin)
                                  (<= % (- goal sum))) coins)] 
    ;; if there are no more valid coins, we return 1 if we reach the goal
    (if (empty? valid-coins)
      (if (= sum goal) 1 0)
      (reduce + (map #(coin-combos (+ sum %) goal %) valid-coins)))))

(defn euler031 []
  (coin-combos 0 200 200) )

(time (println (euler031)))
