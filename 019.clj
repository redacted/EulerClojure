;; stolen from euler-clojure
;; nice example of java interop

(import '(java.util GregorianCalendar))

(defn euler019 []
  (let [cal (GregorianCalendar.)
        xs (for [year (range 1901 2001) month (range 1 13)]
             (do
               ; set the data to year-month-1, if sunday 1 else 0
               (.set cal year month 1)
               (if (= (.get cal GregorianCalendar/DAY_OF_WEEK) GregorianCalendar/SUNDAY)
                 1
                 0)))]
    (reduce + xs)))

(println (euler019))


