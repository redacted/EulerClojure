(use 'clojure.contrib.math)

(defn euler097 []
  (let [exponentiated (bit-shift-left 2 7830456)]
    (mod (inc (* 28433 exponentiated)) (expt 10 10))))

(time (println (euler097)))



