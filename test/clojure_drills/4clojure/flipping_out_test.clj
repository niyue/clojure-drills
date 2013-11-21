; http://www.4clojure.com/problem/126

(ns clojure-drills.4clojure.through-the-looking-class-test
  (:use clojure.test
        clojure-drills.core))

(defn flip-out [f]
  (fn [& args]
    (apply f (reverse args))))

(deftest flipping-out-test
  (is (= 2 ((flip-out quot) 4 8))))
