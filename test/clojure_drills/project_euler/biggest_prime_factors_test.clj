; http://projecteuler.net/problem=3

(ns clojure-drills.project-euler.biggest-prime-factors-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(math/sqrt 1000)

(defn primes [n]
  [1 2 3])

(some
 #(zero? (mod 600851475143 %))
 (reverse (primes 600851475143)))
