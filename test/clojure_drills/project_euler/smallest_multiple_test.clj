; http://projecteuler.net/problem=5

(ns clojure-drills.project-euler.smallest-multiple-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(reduce #(math/lcm % %2) 1 (range 1 21))
