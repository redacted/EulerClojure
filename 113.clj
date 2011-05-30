;; we want numbers that increase, decrease, or stay the same
;; across an increasing number each digit can be increased 8 times (no leading 0)
;; across a decreasing number each digit can be decreased 9 times
;; so the answer is the number of ways you can increase or keep the same plus
;; the number of was you can decrease or keep the same (- 10 to avoid double
;; counting)
;; this is done in euler113 (calling monotonic-per-power)
;;
;; the problem can be reduced to (choose 110 10) + (choose 109 9) - 1002
;; euler113alt
;; The last formula can be directly derived in the following manner. 
;; Imagine your numbers right aligned when printing (100 columns). 
;; Every k-digit increasing number then consists of 100-k tabs + its own digits. 
;; Such a number consists of at most 9+1=10 different characters. 
;; Now we only have to consider numbers of exactly 100 characters. 
;; That means (see also eulers post) that there are c(109,9)-1 such numbers. 
;; (-1 for the numbers consisting entirely out of tabs.) 
;; A k-digit decreasing number consists of at most 10+1=11 different characters.
;; That means there are c(110,10)-1 such numbers. 
;; Then correct for numbers entirely consisting of the same digit, so subtract 10*n. 

(use 'clojure.contrib.math)

(defn factorial [x]
  (apply * (range 2 (inc x))))

(defn choose
  "a choose b"
  [a b] (/ (factorial a) (* (factorial b) (factorial (- a b))))) 

(defn monotonic-per-power 
  [n] (- (+ (choose (+ n 8) n) (choose (+ n 9) n)) 10)) 

(defn euler113 []
  (reduce + (map monotonic-per-power (range 1 101))))

(defn euler113alt [n]
  (- (+ (choose (+ 10 n) 10) (choose (+ 9 n) 9)) (* 10 n) 2))

(time (println "mapped:" (euler113)))
(time (println "direct:" (euler113alt 100)))
