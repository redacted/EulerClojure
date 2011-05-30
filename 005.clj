; want to find the smallest positive number evenly divisible by all numbers 1..20

(defn gcd [a b]
    "(gcd a b) computes the greatest common divisor of a and b."
    (if (zero? b)
        a
      (recur b (mod a b)))) ; This is (gcd b (mod a b)), but with explicit tail call optimization.

(defn lcm [a b]
  "(lcd a b) returns the lowest common multiple of a b"
  (/ (* a b) (gcd a b)))

(defn euler005 []
  (reduce #(lcm %1 %2) (range 1 21)))

(time (println (euler005)))


