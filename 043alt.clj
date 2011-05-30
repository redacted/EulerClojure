;; from clojure-euler, macro madness by Kotarak
;; ~1000 times faster o_0

(defn digits->int
  [ds]
  (reduce #(+ (* 10 %1) %2) ds))

(defn divisible? [a b] (zero? (rem a b)))

(defmacro permute
  [xs bind action]
  (let [gxs (gensym "permute_xs__")]
    `(let [~gxs ~xs]
       (for ~(loop [[f & r] bind
                    vars    #{}
                    res     []]
               (cond
                 (keyword? f) (recur (rest r)
                                     vars
                                     (conj res f (first r)))
                 f            (recur r
                                     (conj vars f)
                                     (conj res f (if (< 0 (count vars))
                                                   `(apply disj ~gxs ~vars)
                                                   gxs)))
                 :else        res))
         ~action))))

(defn euler-43
  []
  (reduce + (permute #{0 1 2 3 4 5 6 7 8 9}
                     [d5 :when (contains? #{0 5} d5)
                      d3 :when (contains? #{0 2 4 6 8} d3)
                      d2
                      d4 :when (divisible? (+ d2 d3 d4) 3)
                      d6 :when (divisible? (digits->int [d4 d5 d6]) 7)
                      d7 :when (divisible? (digits->int [d5 d6 d7]) 11)
                      d8 :when (divisible? (digits->int [d6 d7 d8]) 13)
                      d9 :when (divisible? (digits->int [d7 d8 d9]) 17)
                      d1
                      d0 :when (not= 0 d0)]
                     (digits->int [d0 d1 d2 d3 d4 d5 d6 d7 d8 d9]))))

(time (println (euler-43)))
