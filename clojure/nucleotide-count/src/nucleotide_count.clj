(ns nucleotide-count)


(def nucleotides #{\A \C \T \G})

(defn count [nucleotide strand]
  {:pre [(nucleotides nucleotide)]}
  (clojure.core/count (filter #{nucleotide} strand)))

(defn nucleotide-counts [strand]
  (into {} (for [n nucleotides] [n (count n strand)])))
