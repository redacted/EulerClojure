(defn number-of-ascii-chars [s]
  (count (filter #(or (and (<= (int \a) %) (<= % (int \z)))
                      (and (<= (int \A) %) (<= % (int \Z)))
                      (= (int \newline) %)
                      (= (int \space) %)) 
                 (map int s))))

(defn decrypt [s key]
  (map bit-xor s (cycle key)))

(defn euler059 [file]
  (let [message (map #(Integer/parseInt %) (re-seq #"\d+" (slurp file)))
        lower (map int "abcdefghijklmnopqrstuvwxyz")
        best-match (first (sort-by second >
                              (for [a lower
                                    b lower
                                    c lower]
                                [(str (char a) (char b) (char c))
                                 (number-of-ascii-chars (decrypt message [a b c]))])))
        decrypted (decrypt message (map int (first best-match)))]
    (println "key: " best-match)
    (println "message: " (apply str (map char decrypted)))
    (println (reduce + decrypted))))


(time (euler059 "cipher1.txt"))
