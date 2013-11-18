; http://www.4clojure.com/problem/40

(ns clojure-drills.4clojure.interpose-a-seq-test
  (:use clojure.test
        clojure-drills.core))

(defn interpo [s coll]
  (rest
   (interleave (repeat s) coll)))

(deftest interpose-a-seq-test
    (is (= [1 0 2 0 3] (interpo 0 [1 2 3]))))
