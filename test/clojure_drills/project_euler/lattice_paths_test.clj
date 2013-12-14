; http://projecteuler.net/problem=15

(ns clojure-drills.project-euler.sum-square-difference-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))


(defn paths [x y]
  (if (or (zero? x) (zero? y))
    1
    (+ (paths (dec x) y) (paths x (dec y)))))

;(paths 2 2)


