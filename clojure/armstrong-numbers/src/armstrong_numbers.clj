(ns armstrong-numbers
  (:require [clojure.string :refer [split]]))


(defn exp [x n]
  (reduce * (repeat n x)))


(defn num->digits [num]
  (loop [x num
         xs '()]
    (if (< x 10)
      (conj xs x)
      (recur (int (/ x 10)) (conj xs (rem x 10))))))


(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (num->digits num)
        len (count digits)
        raised (map #(exp % len) digits)
        total (reduce + raised)]
    (= total num)))
