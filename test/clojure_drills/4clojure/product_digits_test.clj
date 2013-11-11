; http://www.4clojure.com/problem/99

(ns clojure-drills.4clojure.product-digits-test
  (:use clojure.test
        clojure-drills.core))
(defn pd [x y]
  (map
   #(Long/valueOf (str %))
   (str (* x y))))

(deftest product-digits-test
    (is (= [1]
           (pd 1 1))))
