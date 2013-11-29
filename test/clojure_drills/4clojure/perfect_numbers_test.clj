; http://www.4clojure.com/problem/80

(ns clojure-drills.4clojure.perfect-numbers-test
  (:use clojure.test
        clojure-drills.core))

(defn perfect? [n]
  (let [factors (filter #(zero? (rem n %)) (range 1 n))]
    (= n (apply + factors))))

(deftest perfect-numbers-test
    (is (= (perfect? 6) true)))

(deftest non-perfect-numbers-test
    (is (= (perfect? 7) false)))
