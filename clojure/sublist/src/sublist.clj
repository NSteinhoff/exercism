(ns sublist)


(defn sublist? [xs ys]
  (->> ys
    (partition (count xs) 1)
    (some #{xs})))


(defn classify [list1 list2]
  (cond (= list1 list2)         :equal
        (sublist? list1 list2)  :sublist
        (sublist? list2 list1)  :superlist
        :else                   :unequal))
