; http://projecteuler.net/problem=15

(ns clojure-drills.project-euler.lattice-paths-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))


(defn paths [x y]
  ((memoize
    (fn []
      (if (or (zero? x) (zero? y))
        1
        (+ (paths (dec x) y) (paths x (dec y))))))))

;(paths 10 20)


