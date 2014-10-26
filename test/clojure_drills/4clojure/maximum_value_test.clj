; http://www.4clojure.com/problem/38

(ns clojure-drills.4clojure.maximum-value-test
  (:use clojure.test
        clojure-drills.core))

(defn max-in [& coll]
  (reduce #(if (> % %2) % %2) coll))

(deftest max-function
    (is (= 5 (#(if (> %1 %2) %1 %2) 5 4))))


(deftest maximum-value
    (is (= 5 (max-in 3 5 4))))
