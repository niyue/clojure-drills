; http://www.4clojure.com/problem/98

(ns clojure-drills.4clojure.equivalence-classes-test
  (:use clojure.test
        clojure-drills.core))

(defn equi [f s]
  (set (map set (vals (group-by f s)))))

(deftest equivalence-classes-test
    (is (= (equi #(* % %) #{-2 -1 0 1 2}))))

