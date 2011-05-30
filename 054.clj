(use '[clojure.contrib.duck-streams :only (read-lines)])

;; assign a numerical value to each card
(def card-nums (zipmap "23456789TJQKA" (iterate inc 2)))

;; assign a numerical rank to each hand type
;; royal flush is the highest scoring stright flush, so
;; it gets handled by tie-breaking code
(def hand-rank (zipmap [:straight-flush
                        :four-of-a-kind
                        :full-house
                        :flush
                        :straight
                        :three-of-a-kind
                        :two-pairs
                        :pair
                        :high-card] (range)))

(defn card-val [c] (card-nums (first c)))

(defn hand
  "Returns the type of the hand and a list of the card groups.
   e.g. (6H 6S 6C KS KH) -> [:full-house ([6H 6S 6C] [KS KH])]"
  [cards]
  (let [cs (sort-by card-val > cards) 
        cn (into (sorted-set) (map card-val cs))
        straight? (and (= 5 (count cn)) (= 4 (- (last cn) (first cn))))
        flush? (apply = (map second cards))
        groups (sort-by count > (vals (group-by card-val cs)))
        g1 (count (first groups))
        g2 (count (second groups))
        hand-type (cond
                   (and straight? flush?)  :straight-flush
                   (= 4 g1)                :four-of-a-kind
                   (and (= 3 g1) (= 2 g2)) :full-house
                   flush?                  :flush
                   straight?               :straight
                   (= 3 g1)                :three-of-a-kind
                   (and (= 2 g1) (= 2 g2)) :two-pairs
                   (= 2 g1)                :pair
                   :else                   :high-card)]
    [hand-type groups]))

(defn break-tie
  "Assuming that g1 and g2 represent the same type of hand (eg: full house),
  returns the outcome for the g1 hand (:win, :lose, or rarely :tie). Compares
  the 1st group of both hands, then the second, etc.
  e.g. two full houses: [6H 6S 6C] [KS KH] and [8H 8S 8C] [TS TH]
  a = 6H, b = 8H, b wins"
  [g1 g2]
   (let [a (first (first g1))
         b (first (first g2))]
    (if (or (nil? a) (nil? b))
      :tie
      (cond
       (> (card-val a) (card-val b)) :win
       (< (card-val a) (card-val b)) :lose
       :else (recur (next g1) (next g2))))))

(defn p1-win? [p1 p2]
  (let [[t1 g1] (hand p1)
        [t2 g2] (hand p2)]
    (cond
     (< (hand-rank t1) (hand-rank t2)) :win
     (> (hand-rank t1) (hand-rank t2)) :lose
     :else (break-tie g1 g2))))

(defn euler054 [file]
  (count
   (for [line (read-lines file)
         [p1 p2] [(split-at 5 (re-seq #"\w+" line))]
         :when (= (p1-win? p1 p2) :win)]
     :win)))

(time (println (euler054 "poker.txt")))

