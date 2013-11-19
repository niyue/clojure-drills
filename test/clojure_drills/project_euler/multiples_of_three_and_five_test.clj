; http://projecteuler.net/problem=1

(ns clojure-drills.project-euler.multiples-of-three-and-five-test
  (:use clojure.test
        clojure-drills.core))

(defn multiple? [x y]
  (zero? (rem x y)))

(defn multiple-3-or-5? [x]
  (or
   (multiple? x 3)
   (multiple? x 5)))

(defn sum35 [n]
   (apply + (filter multiple-3-or-5? (range n))))

(sum35 1000)
