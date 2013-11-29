; http://www.4clojure.com/problem/147

(ns clojure-drills.4clojure.pascal-trapezoid-test
  (:use clojure.test
        clojure-drills.core))

(defn pascal [v]
  (iterate #(vec (map +' (conj % 0) (cons 0 %))) v))

(deftest pascal-trapezoid-test
    (is (= (take 2 (pascal [3 1 2])) [[3 1 2] [3 4 3 2]])))

(deftest pascal-trapezoid-single-vector-test
    (is (= (take 5 (pascal [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])))

(deftest pascal-trapezoid-integer-overflow-test
    (is (= (take 100 (pascal [2 4 2])) (rest (take 101 (pascal [2 2]))))))

; learn:
; 1) +' => BigInteger
