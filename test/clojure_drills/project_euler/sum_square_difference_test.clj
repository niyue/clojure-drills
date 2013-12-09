; http://projecteuler.net/problem=6

(ns clojure-drills.project-euler.sum-square-difference-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(defn sum-diff [n]
  (let [nums (range 1 (inc n))
        sum (reduce + nums)]
  (- (* sum sum)
     (reduce + (map #(* % %) nums)))))

(sum-diff 100)
