; http://www.4clojure.com/problem/56

(ns clojure-drills.4clojure.find-distinct-items-test
  (:use clojure.test
        clojure-drills.core))

(defn distinct-seq [coll]
  (vec (java.util.LinkedHashSet. coll)))

(deftest duplicated-items-test
  (is (= (distinct-seq [1 2 1 3 1 2 4]) [1 2 3 4])))
