; http://www.4clojure.com/problem/59

(ns clojure-drills.4clojure.juxtaposition-test
  (:use clojure.test
        clojure-drills.core))

(defn jxt [& funs]
  (fn [& args]
    (map #(apply % args) funs)))

(deftest juxt-test
  (is (= [16 6] ((jxt + max) 2 3 5 6))))
