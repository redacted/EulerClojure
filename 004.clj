; we want the largest palindromic product of 2 3 digit numbers


(defn palindrome? [s]
  (= (reverse (str s)) (seq (str s))))

(defn biggest_palindrome []
  (apply max (filter palindrome? (for [x (range 100 1000) y (range 100 1000)] (* x y)))))

(println (biggest_palindrome))

