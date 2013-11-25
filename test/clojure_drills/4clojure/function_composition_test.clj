; http://www.4clojure.com/problem/58

(ns clojure-drills.4clojure.function-composition-test
  (:use clojure.test
        clojure-drills.core))

(defn compo [& fns]
  (let [fns (reverse fns)]
    (fn [& args]
      (reduce #(%2 %) (apply (first fns) args) (rest fns)))))

(deftest function-comp-test
  (is (= [3 2 1] ((compo rest reverse) [1 2 3 4]))))

; learn:
; 1) clever destructuring from kohyama's solution and daowen's solution
