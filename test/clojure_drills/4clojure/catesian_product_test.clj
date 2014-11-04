; http://www.4clojure.com/problem/90

(ns clojure-drills.4clojure.catesian-product-test
  (:use clojure.test
        clojure-drills.core))

(defn catesian-product [a b]
  (set (#(for [x % y %2] [x y]) a b)))

(defn cp [a b]
  (set (for [x a y b] [x y])))

(deftest catesian-product-test
  (is (= (catesian-product #{1 2 3} #{4 5})
         #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})))

(deftest catesian-product-test-two
  (is (= (cp #{1 2 3} #{4 5}) #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})))
