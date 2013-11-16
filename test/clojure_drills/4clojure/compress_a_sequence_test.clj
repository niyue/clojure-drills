; http://www.4clojure.com/problem/95

(ns clojure-drills.4clojure.compress-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn comp-seq [s]
  (filter identity (map #(if (not= %1 %2) %1) s (cons nil s))))

(deftest compress-an-empty-sequence-test
    (is (= [] (comp-seq []))))

(deftest compress-single-element-sequence-test
    (is (= [:a] (comp-seq [:a]))))

(deftest compress-two-different-elements-sequence-test
    (is (= [:a :b] (comp-seq [:a :b]))))

(deftest compress-two-same-elements-sequence-test
    (is (= [:a] (comp-seq [:a :a]))))
