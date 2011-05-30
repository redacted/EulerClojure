;; slow, but I like the approach :)

(use 'clojure.contrib.combinatorics)
(use '[clojure.string :only (join)])

(defn int-slice [coll a b]
  (Integer/parseInt (join "" (drop a (take b coll)))))

(def perms (permutations [1 2 3 4 5 6 7 8 9]))

(defn pandigital-mult? [coll]
  (or (= (* (int-slice coll 0 2) (int-slice coll 2 5)) (int-slice coll 5 9))
      (= (* (int-slice coll 0 1) (int-slice coll 1 5)) (int-slice coll 5 9))))

(defn euler030 []
  (reduce + (distinct (map #(int-slice % 5 9) 
                           (filter pandigital-mult? perms)))))

(time (println (euler030)))

