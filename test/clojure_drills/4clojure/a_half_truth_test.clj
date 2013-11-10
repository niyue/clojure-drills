; http://www.4clojure.com/problem/83

(ns clojure-drills.4clojure.a-half-truth-test
  (:use clojure.test
        clojure-drills.core))

(defn half-truth [coll]
  (not (or (every? true? coll) (every? false? coll))))

(deftest a-half-truth-all-false
    (is (= false
           (half-truth [false false]))))

(deftest a-half-truth-all-true
    (is (= false
           (half-truth [true true]))))

(deftest a-half-truth
    (is (= true
           (half-truth [false true]))))
