;; see http://projecteuler.net/index.php?section=forum&id=63 (Alvaro comment)
;; http://projecteuler.net/index.php?section=forum&id=63&page=5 (sedefcho)
;; for explanation of power-bound
;; x^n has n digits when 
;; 10^(n-1) <= x^n < 10^n -> solve for x = f(n)

(use 'clojure.contrib.math)

(defn power-bound [n]
  ;; should use floor, but int is faster!
  (inc (int (/ (Math/log 10) (- (Math/log 10) (Math/log n))))))

(defn euler063 []
  (count (for [a (range 1 10)
               b (range 1 (power-bound a))
               :when (= (count (str (expt a b))) b)]
           [a b])))

(time (println (euler063)))
