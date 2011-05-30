;; we want to minimize the totient
;; Easiest way? just multiply all the primes together (from ookk on problem page)
;;
;; The size of totient function depends on the number of prime factors -
;; more prime factors -> bigger totient
;; (defn totient-count [n]
;;  (let [factors (distinct (prime-factors n))
;;        totient-factors (map #(- 1 (/ 1 %)) factors)]
;;    (reduce * n totient-factors)))     

(use '[clojure.contrib.lazy-seqs :only (primes)])

(def prime-products (reductions * primes))

(defn euler069 []
  (last (take-while #(< % 1000000) prime-products)))

(time (println (euler069)))                     
