; http://projecteuler.net/problem=9

(ns clojure-drills.project-euler.special-pythangorean-triplet-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(defn pythgorean [sum]
  (for [a (range 1 (inc sum))
        b (range (inc a) (inc sum))
        :let [c (- sum a b)]
        :when (= (+ (* a a) (* b b)) (* c c))]
    [a b c]))

(reduce * (first (pythgorean 1000)))
