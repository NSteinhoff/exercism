(ns clock)


(defn- norm [m] (mod m 1440))


(defn clock->string [clock]
  (format "%02d:%02d" (quot clock 60) (mod clock 60)))


(defn clock [hours minutes] (norm (+ (* 60 hours) minutes)))


(defn add-time [clock time] (norm (+ clock time)))
