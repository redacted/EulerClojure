(defn palindrome? [s]
  (let [s_ (str s)]
    (= (reverse s_) (seq s_))))

(defn euler036 [limit]
  ;; even numbers can't be palindromic in binary as they always end in zero
  (let [numbers (range 1 (inc limit) 2)
        base10p (filter palindrome? numbers)
        base2+10p (filter #(palindrome? (Integer/toBinaryString %)) base10p)]
    (reduce + base2+10p)))

(time (println (euler036 1000000)))
