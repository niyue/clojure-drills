; http://www.4clojure.com/problem/126

(ns clojure-drills.4clojure.through-the-looking-class-test
  (:use clojure.test
        clojure-drills.core))

(defn looking-class? [x]
  (and
   (= (class x) x)
   x))

(deftest looking-class-test
  (is (looking-class? Class)))

(deftest false-looking-class-test
  (is (= false
         (looking-class? Integer))))
