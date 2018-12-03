(ns leap)

(defn leap-year? [year]
  (let [div-by? #(zero? (rem year %))]
    (if (div-by? 100)
      (div-by? 400)
      (div-by? 4))))
