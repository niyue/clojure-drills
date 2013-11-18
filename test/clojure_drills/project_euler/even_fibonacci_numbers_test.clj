; http://projecteuler.net/problem=2

(ns clojure-drills.project-euler.even-fibonacci-numbers-test
  (:use clojure.test
        clojure-drills.core))

(defn fib [a b]
  (map first (iterate (fn [[a b]] [b (+ a b)]) [a b])))

(apply + (filter even? (take-while (partial >= 4000000) (fib 1 1))))
