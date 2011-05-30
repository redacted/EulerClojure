;; From Assato on project euler forums
;;
;; My method hamming(a,b) returns how many generalized Hamming number of type b 
;; (this property is also called b-smoothness) exists below a (important: 
;; actually, in my code, hamming(a,b) returns how many numbers below a are
;; primes(b)-smooth). 
;;
;; Surely the amount of numbers 2-smooth below any given value can be 
;; calculated by logarithms: these would be the numbers 1,2,4,8,... 
;; until 2n surpasses a. 
;;
;; Otherwise, if b 2, we can calculate hamming(a,b) recursively. Just to 
;; illustrate the idea I'll use b=7: 
;;
;; Let's calculate hamming(a,7). There are two types of 7-smooth numbers: 
;; (i) those that are actually 5-smooth, and
;; (ii) those that contains at least one factor 7. 
;;
;; (i) is obviously hamming(a,5). 
;; And, the key point, (ii) is hamming(a/7 , 7). This is true because 
;; hamming(a/7,7) contains ALL 7-smooth values until a/7 (those that contains
;; the factor 7 and those who don't). By multiplying each of them by 7, we'll
;; get each and every 7-smooth number under a that contains at least one 7 
;; factor. 
;;
;; So, hamming(a,7) = hamming(a,5) + hamming(a/7, 7). 


(def primes [ 2 3 5 7 11 13 17 
             19 23 29 31 37 41 
             43 47 53 59 61 67 
             71 73 79 83 89 97])

(defn hamming [i j]
  (cond
    (zero? i) 0
    (zero? j) (int (+ 1 (/ (Math/log i) (Math/log 2))))
    :else (+ (hamming i (dec j)) (hamming (int (/ i (nth primes j))) j))))

(defn euler204alt [limit]
  (hamming limit (dec (count primes))))

(time (println (euler204alt 1e11)))
