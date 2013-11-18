; http://www.4clojure.com/problem/157

(ns clojure-drills.4clojure.indexing-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn index-seq [coll]
  (map #(vector %1 %2) coll (iterate inc 0)))

(deftest indexing-sequence-test
    (is (= [[:a 0] [:b 1] [:c 2]]
           (index-seq [:a :b :c]))))
