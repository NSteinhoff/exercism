(ns grade-school)

(defn grade [school grade]  ;; <- arglist goes here
  (school grade [])
)

(defn add [school name grade]  ;; <- arglist goes here
  (update school grade #(vec (conj % name)))
)

(defn sort-vals [m]
  (for [[k vs] m] [k (sort vs)])
)

(defn sorted [school]  ;; <- arglist goes here
  (->> school
    (sort-vals)
    (into (sorted-map)))
)
