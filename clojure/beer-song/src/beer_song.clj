(ns beer-song)

(def verses
  "Map of the different verses."
  {:none (str "No more bottles of beer on the wall, no more bottles of beer.\n"
              "Go to the store and buy some more, 99 bottles of beer on the wall.\n")
   :some (str "%1$s of beer on the wall, %1$s of beer.\n"
              "Take %3$s down and pass it around, %2$s of beer on the wall.\n")})


(defn bottles [num]
  "Returns the description of the number of bottles."
  (cond
    (= num 0) "no more bottles"
    (= num 1) "1 bottle"
    :else (format "%s bottles" num)))


(defn verse
 "Returns the nth verse of the song."
 [num]
 (if (= num 0)
   (:none verses)
   (format
     (:some verses)
     (bottles num)
     (bottles (dec num))
     (if (= num 1) "it" "one"))))


(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
   end is not given, the whole song from start is sung."
  ([start]
   (sing start 0))
  ([start end]
   (->> (range start (dec end) -1)
        (map verse)
        (interpose "\n")
        (apply str))))
