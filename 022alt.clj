;; alternate method using interleave to initialize hashmap as lookup table
(def *letters* "ABCDEFGHIJKLMNOPQRSTUVWXYZ")

(def char2num (apply hash-map (interleave *letters* (iterate inc 1))))

(defn letterscore [s]
  "Returns the score of the letters of string s."
  (reduce + (map #(char2num %) s)))

;; use a regex to pull out the names
(defn get-names [namestr]
  (re-seq #"\w+" namestr))

(defn euler-22 [namefile]
  (let [names (sort (get-names (slurp namefile)))]
    (reduce + (map * (map letterscore names) (iterate inc 1)))))

(time (println (euler-22 "names.txt")))
