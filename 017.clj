; stolen from Clojure-Euler

(def a0 '("one" "two" "three" "four" "five" "six" "seven" "eight"
            "nine" "ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen"
            "sixteen" "seventeen" "eighteen" "nineteen"))
(def a1 '("twenty" "thirty" "forty" "fifty" "sixty" "seventy"
            "eighty" "ninety"))

(defn to_words [n]
  (cond
    ; hard code numbers less than 20, note indexed from zero
    (< n 20) (nth a0 (dec n))
    ; now from 20-99 we do tens
    ; if multiple of ten, return just that number [index (n-20)/10]
    ; else add the remainder, indexed into a0
    (< n 100) (if (zero? (rem n 10))
                (nth a1 (/ (- n 20) 10))
                (str (nth a1 (/ (- n 20) 10)) (nth a0 (dec (rem n 10)))))
    ; for the hundreds, test remainder, return n hundreds and recurse for the remainder
    (< n 1000) (if (zero? (rem n 100))
                 (str (to_words (/ n 100)) "hundred")
                 (str (to_words (/ n 100)) "hundredand" (to_words (rem n 100))))
    (= n 1000) "onethousand"))

(println (.length (reduce str (map to_words (range 1 1001)))))

