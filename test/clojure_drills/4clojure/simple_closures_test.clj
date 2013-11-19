; http://www.4clojure.com/problem/107

(ns clojure-drills.4clojure.simple-closures-test
  (:require clojure.test))

(defn pow [x]
   (fn [y]
     (apply * (repeat x y))))

(deftest pow-fn-test
  (is (= 256 ((pow 2) 16))))
