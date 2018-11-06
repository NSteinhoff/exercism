(ns hamming)

(defn distance [strand1 strand2]
  (when (= (count strand1) (count strand2))
    (->> (map = strand1 strand2)
         (filter not)
         (count)))
)
