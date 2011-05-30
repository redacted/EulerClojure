(defn collatz [n] (take-while identity 
	(iterate #(cond 
		(even? %) (/ % 2)
		(= % 1) nil
		:else (inc (* % 3)))
	n)))

(time (println (last (sort (map #(vector (count (collatz %)) %) (range 1 1000000))))))


