; http://projecteuler.net/problem=14

(ns clojure-drills.project-euler.longest-collatz-sequence-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(defn even-next [n]
  (/ n 2))

(defn odd-next [n]
  (inc (* n 3)))

(defn next [n]
  ((if (even? n) even-next odd-next) n))

(defn collatz [n]
  (concat (take-while #(not= % 1) (iterate next n)) [1]))

;(apply max-key count (map collatz (range 1 100)))

