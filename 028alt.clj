(defn euler-28-revised [n]
  "Compute the sum of the diagonals in an n by n clockwise spiral. "
  " work inwards, decreasing the side length m by 2 each time"
  (let [diags (fn [m] (take 4 (iterate #(- % (dec m)) (* m m))))
        squares (take-while #(> % 1) (iterate #(- % 2) n))]
    (reduce + (flatten [(map diags squares) 1]))))

(time (println (euler-28-revised 10001)))

