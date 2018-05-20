(ns armstrong-numbers
  (:require [clojure.string :refer [split]]))


(defn exp [x n]
  (reduce * (take n (repeat x))))


(defn num->digits [num]
  (let [strg (str num)
        chrs (split strg #"")
        digits (map read-string chrs)]
    digits))


(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (num->digits num)
        len (count digits)
        raised (map #(exp % len) digits)
        total (reduce + raised)]
    (= total num)))
