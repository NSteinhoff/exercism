(ns phone-number)

(def r #"\+?1?[\s-\.]?\(?(\d{3})\)?[\s-\.]?(\d{3})[\s-\.]?(\d{4})")

(defn matches [num-string]
  (->> num-string
       (re-matches r)
       (rest)))

(defn number [num-string]
  (apply str (or (not-empty (matches num-string)) ["0000000000"])))

(defn number' [num-string]
  (let [m (matches num-string)]
    (if (empty? m)
      "0000000000"
      (apply str m))))

(def area-code (comp first matches))

(def pretty-print (comp (partial apply format "(%s) %s-%s") matches))
