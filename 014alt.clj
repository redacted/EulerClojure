(defn max-at [s]
  "Returns [xi x], where xi is the index number of the max element,
  (indexed from 1) and x is the max of s."
  (letfn [(find-max [s n x xi]
             (let [f (first s)
                   r (rest s)]
               (if (nil? f)
                 [xi x]
                 (if (> f x)
                   (recur r (inc n) f n)
                   (recur r (inc n) x xi)))))]
    (find-max s 1 0 0)))

(defn collatz-next [n]
  "Returns the next number in a collatz sequence."
  (cond
    (= n 1) 1
    (odd? n) (+ 1 (* 3 n))
    true (/ n 2)))

(defn collatz-seq [n]
  "Returns a lazy list of numbers in a collatz sequence."
  (iterate collatz-next n))

(defn collatz-stack [vc n]
  "Returns a lazy list of numbers in a collatz sequence that aren't in vector vc."
  (let [stack (take-while #(not (and (> n %) (vc %))) (collatz-seq n))]
    stack))

(defn collatz-value [vc]
  "'Appends' the length of the collatz sequence for the last value.
  Zero indexed... Ex: Given [0 1 2], returns 8."
  (let [n (count vc)
        s (collatz-stack vc n)]
    (conj vc (+ (count s) (vc (collatz-next (last s)))))))

(def lazy-collatz-vec (iterate collatz-value [0 1 2]))

(defn euler-14-lazy-vec [n]
  (max-at (nth lazy-collatz-vec n)))

(time (println (euler-14-lazy-vec 1000000)))
