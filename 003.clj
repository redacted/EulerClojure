; Euler 003: determine prime factors of large number (600851475143)
; use a recursive function that takes the number and the largest current factor

(defn factor [num cur]
  ; if num == current best then num is the best prime, return it
  (if (= num cur)
    num
  ; if the num % cur == 0 then divide it out, and call factor recursively
  (if (zero? (mod num cur))
      (factor (/ num cur) cur)
  ; else increment cur and call factor recursively
  (factor num (inc cur)))))


(time (println (factor 600851475143 2)))
