(ns etl
  (:require [clojure.string :as s]))

(defn flip [m] (for [[k vs] m, v vs] [v k]))

(defn map-keys [f m] (for [[k v] m] [(f k) v]))

(defn transform [source]
  (->> source
       (flip)
       (map-keys s/lower-case)
       (into {})))
