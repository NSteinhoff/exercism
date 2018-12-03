(ns robot-name)

(def letters "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(def numbers (range 1 10))
(def robots (atom #{}))


(defn names []
  (into #{} (for [robot @robots] {:name @robot})))

(defn unique? [name]
  (not ((names) name)))

(defn rand-name []
  (->> (concat (repeat 2 letters)
               (repeat 3 numbers))
    (map rand-nth)
    (apply str)))

(defn next-name []
  (->> (repeatedly rand-name)
    (filter unique?)
    (first)))

(defn robot []
  (let [robot (atom {:name (next-name)})]
    (swap! robots #(conj % robot))
    robot))

(defn robot-name [robot]
  (:name @robot))

(defn reset-name [robot]
  (swap! robot #(assoc % :name (next-name))))
