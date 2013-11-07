; http://www.4clojure.com/problem/38

(ns clojure-drills.4clojure.maximum-value-test
  (:use clojure.test
        clojure-drills.core))

(deftest max-function
    (is (= 5 (#(if (> %1 %2) %1 %2) 5 4))))


(deftest maximum-value
    (is (= 5 ((fn [& coll] (reduce #(if (> %1 %2) %1 %2) 0 coll)) 3 5 4))))
