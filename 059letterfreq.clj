(def letters "abcdefghijklmnopqrstuvwxyz") 

;; For English text. From http://en.wikipedia.org/wiki/Letter_frequency
(def letter-freq {\a 11.602, \b 4.702, \c 3.511, \d 2.670, \e 2.000,
                  \f 3.779,  \g 1.950, \h 7.232, \i 6.286, \j 0.631,
                  \k 0.690,  \l 2.705, \m 4.374, \n 2.365, \o 6.264,
                  \p 2.545,  \q 0.173, \r 1.653, \s 7.755, \t 16.671
                  \u 1.487,  \v 0.619, \w 6.661, \x 0.005, \y 1.620,
                  \z 0.050})

(defn xor-chars [a b]
  (char (bit-xor (int a) (int b))))

(defn char-score [c s]
  (reduce + (remove nil? (map #(letter-freq (xor-chars % c)) s))))

(defn best-char [s]
  (first (apply max-key second (zipmap letters (map #(char-score % s) letters)))))


;; now with maps to show off pmap
(defn euler-59-sequential [keylength file]
  (let [msg (map #(char (Integer/parseInt %)) (re-seq #"\d+" (slurp file)))
        ks (map (fn [k] (best-char  (take-nth keylength (drop k msg))))
                 (range 0 keylength))
        decrypted (apply str (map xor-chars msg (cycle ks)))]
    (println ks)
    (reduce + (map #(int %) decrypted))))

(defn euler-59-parallel [keylength file]
  (let [msg (map #(char (Integer/parseInt %)) (re-seq #"\d+" (slurp file)))
        ks (pmap (fn [k] (best-char  (take-nth keylength (drop k msg))))
                 (range 0 keylength))
        decrypted (apply str (map xor-chars msg (cycle ks)))]
    (reduce + (map #(int %) decrypted))))


(dotimes [_ 5]
  (time (euler-59-sequential 3 "cipher1.txt")))

(dotimes [_ 5]
  (time (euler-59-parallel 3 "cipher1.txt")))

(shutdown-agents)
