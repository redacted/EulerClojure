(use 'clojure.contrib.combinatorics)

(def permloop (cycle (permutations [0 1 2 3 4 5 6 7 8 9])))

(defn euler024 [target]
  ;; target - 1 -> permutations are zero indexed 
  (drop 1 (take 2 (take-nth (dec target) permloop))))

(time (println (euler024 1000000)))
