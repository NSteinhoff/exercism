(ns collatz-conjecture)


(defn step [x]
  (if (even? x)
    (/ x 2)
    (inc (* x 3))))


(defn collatz [num]
  {:pre [(pos? num)]}
  (loop [x num steps 0]
    (if (= x 1)
      steps
      (recur (step x) (inc steps))))
)
