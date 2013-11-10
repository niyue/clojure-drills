; http://www.4clojure.com/problem/38

(ns clojure-drills.4clojure.dot-product-test
  (:use clojure.test
        clojure-drills.core))

(defn dot-product [x y]
  (reduce + 0 (map #(* %1 %2) x y)))

(deftest dot-product-1-matrix-test
    (is (= 2
           (dot-product [1] [2]))))

(deftest dot-product-2-matrix-test
    (is (= 5 (dot-product [1 1] [2 3]))))
