;; generate all primes, then test if pandigital - slow
;; see alt for faster idea - generate permuations of pandigital numbers
;;  and test for primality
(defn lazy-primes []
  (letfn [(enqueue [sieve n step]
            (let [m (+ n step)]
              (if (sieve m)
                (recur sieve m step)
                (assoc sieve m step))))
          (next-sieve [sieve n]
            (if-let [step (sieve n)]
              (-> sieve
                  (dissoc n)
                  (enqueue n step))
              (enqueue sieve n (+ n n))))
          (next-primes [sieve n]
            (if (sieve n)
              (recur (next-sieve sieve n) (+ n 2))
              (cons n (lazy-seq (next-primes (next-sieve sieve n) (+ n 2))))))]
    (cons 2 (lazy-seq (next-primes {} 3)))))              

;; (1+2+3+4+5+6+7+8+9=45 => always dividable by 3) 
;; (1+2+3+4+5+6+7+8=36 => always dividable by 3) 
;; So n = 7 is the maximum      
;; http://mathworld.wolfram.com/DivisibilityTests.html
(def primes-to-test (take-while #(<= % 7654321) (lazy-primes)))

(defn pandigital? [n]
  (let [s (map #(Integer/parseInt (str %)) (seq (str n)))
        l (count s)]
         (= (range 1 (inc l)) (sort s))))

(defn euler041 []
  (first (filter pandigital? (reverse primes-to-test))))

(time (println (euler041)))
