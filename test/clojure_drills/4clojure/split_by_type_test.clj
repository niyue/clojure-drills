; http://www.4clojure.com/problem/50

(ns clojure-drills.4clojure.split-by-type-test
  (:use clojure.test
        clojure-drills.core))

(defn split-by-type [coll]
  (vals (group-by type coll)))

(deftest split-by-type-test
  (is (= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})))
