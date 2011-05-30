;; calculated permutations directly
;; http://blog.singhanuvrat.com/problems/project-euler-the-millionth-lexicographic-permutation-of-the-digits
;; for good explanation of technique (not algorithm)


(defn all-but-nth [coll n]
  "Returns a list of all items in coll except the nth item. (zero indexed)"
  (lazy-cat (take n coll) (drop (inc n) coll)))

(defn factorial [n]
  (reduce * (range 2 (inc n))))

(defn num-permutations [coll]
  (factorial (dec (count coll))))

(defn nth-permutation [coll n]
  ;; one item in coll
  (if (= 1 (count coll))
    ;; return the item at index 0
    [(nth coll 0)]
    ;; else f = number of permutations of the coll
    (let [f (num-permutations coll)
          ;; x is quotient of n / f
          x (quot n f)]
      ;; concat the value at index x of coll
      (concat [(nth coll x)]
              ;; with recursive call, coll has x'th item removed, n replaced with n - x*f
              (nth-permutation (all-but-nth coll x)
                               (- n (* x f)))))))

(defn euler-24-fast [n]
  (nth-permutation [0 1 2 3 4 5 6 7 8 9] (dec n)))

(time (println (euler-24-fast 1000000))) ;; Elapsed time: 0.361691 msecs"

