; http://www.4clojure.com/problem/22

(ns clojure-drills.4clojure.count-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn cnt [coll]
  (reduce (fn [s x] (inc s)) 0 coll))

(deftest count-seq-test
  (is (= 3 (cnt [1 2 3]))))
