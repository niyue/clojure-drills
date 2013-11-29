; http://www.4clojure.com/problem/80

(ns clojure-drills.4clojure.partition-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn partition-seq [n coll]
  (partition-by
    #(quot % n)
    (take
     (* (quot (count coll) n) n)
     coll)))

(deftest partition-seq-test
  (is (= (partition-seq 3 (range 8)) '((0 1 2) (3 4 5)))))
