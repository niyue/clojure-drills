; http://www.4clojure.com/problem/26

(ns clojure-drills.4clojure.fibonacci-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn fibs [n]
  (take n
        (map first
             (iterate
              (fn [[a b]] [b (+ a b)]) [1 1]))))

(deftest fibonacci-sequence-test
    (is (= [1 1 2] (fibs 3))))
