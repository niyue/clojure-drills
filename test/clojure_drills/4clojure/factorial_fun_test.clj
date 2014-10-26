; http://www.4clojure.com/problem/42

(ns clojure-drills.4clojure.factorial-fun-test
  (:use clojure.test
        clojure-drills.core))


(defn factorial [n]
  (reduce * (range 1 (inc n))))


(deftest factorial-test
  (is (= 6 (factorial 3))))

; this problem was originally solved in a recursive way
