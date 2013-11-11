; http://www.4clojure.com/problem/81

(ns clojure-drills.4clojure.set-intersection-test
  (:use clojure.test
        clojure-drills.core))

(defn set-intersect [c1 c2]
  (set (filter #(contains? c2 %) c1)))

(deftest set-intersect-test
    (is (= #{2 3}
           (set-intersect #{1 2 3 4} #{2 3 5}))))
