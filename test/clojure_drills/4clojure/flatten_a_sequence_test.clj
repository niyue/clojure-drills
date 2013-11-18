; http://www.4clojure.com/problem/28

(ns clojure-drills.4clojure.flatten-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn flat [e]
  (if (coll? e)
    (reduce #(if (coll? %2)
               (concat %1 (flat %2))
               (concat %1 (vector %2))) [] e)
    e))

(deftest flatten-empty-vector-test
  (is (= []
       (flat []))))

(deftest flatten-single-element-vector-test
  (is (= [:a]
       (flat [:a]))))

(deftest flatten-nested-single-element-vector-test
  (is (= [:a]
       (flat [[:a]]))))

(deftest flatten-two-elements-vector-test
  (is (= [:a :b]
       (flat [:a :b]))))

(deftest flatten-seq-test
  (is (= [:a :b :c]
       (flat [:a [:b] :c]))))
