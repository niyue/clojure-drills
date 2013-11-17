; http://www.4clojure.com/problem/166

(ns clojure-drills.4clojure.comparisons-test
  (:use clojure.test
        clojure-drills.core))

(defn comp-less [less a b]
  (cond
   (less a b) :lt
   (less b a) :gt
   :else :eq))

(deftest great-than-test
  (is (= :gt (comp-less < 5 1))))
