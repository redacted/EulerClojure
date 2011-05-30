;; the target matches 1_2_3_4_5_6_7_8_9_0
;; only numbers ending in 0 have squares ending in 0
;; _9_0 must be from _30**2 -> 900 or _70**2 -> 4900
;; so we can iterate in steps of 100, checking the _30 and _70 each time
;; set upper bound to _1000 above the maximum (Math/sqrt 1929394959697989990)
;; (_1000 to be safe!)
;;  1389026623 -> 1389027000

(defn correct-square? [n]
  (= (apply str (take-nth 2 (str (* n n)))) "1234567890"))

(defn test-n [n]
  (let [a (+ n 30)
        b (+ n 70)]
    (cond
      (correct-square? a) a
      (correct-square? b) b
      :else false)))   

(defn euler206 []
  (first (filter #(not (false? %)) 
                 (map test-n (range 1389027000 0 -100)))))

(time (println (euler206)))
