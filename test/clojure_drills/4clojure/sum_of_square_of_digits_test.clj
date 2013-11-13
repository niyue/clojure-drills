; http://www.4clojure.com/problem/120

(ns clojure-drills.4clojure.sum-of-square-of-digits-test
  (:use clojure.test
        clojure-drills.core))

(defn sum-square-digits [coll]
  (count
   (filter
    (fn [c]
       (< c
          (apply
           +
           (map
            #(* (Integer/valueOf (str %)) (Integer/valueOf (str %)))
            (str c)))))
    coll)))

(deftest sum-of-square-of-digits-test
    (is (= 8
           (sum-square-digits (range 10)))))
