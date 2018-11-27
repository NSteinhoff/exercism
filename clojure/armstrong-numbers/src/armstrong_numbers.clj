(ns armstrong-numbers
  (:require [clojure.string :refer [split]]))


(defn exp [x n]
  (reduce * (repeat n x)))


(defn exp-by [n]
  (fn [x] (exp x n)))


(defn digits [num]
  (loop [x num
         xs '()]
    (if (< x 10)
      (conj xs x)
      (recur (bigint (/ x 10)) (conj xs (rem x 10))))))


(defn raise [digits]
  (map (exp-by (count digits)) digits))


(defn armstrong? [num]
  (->> num
    (digits)
    (raise)
    (reduce +)
    (= num)))
