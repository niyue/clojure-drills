; http://www.4clojure.com/problem/33

(ns clojure-drills.4clojure.replicate-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn replicate-seq [coll n]
  (reduce #(concat %1 (repeat n %2)) [] coll))

(deftest replicate-a-sequence
    (is (= '(1 1 2 2)
           (replicate-seq [1 2] 2))))
