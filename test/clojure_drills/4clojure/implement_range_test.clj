; http://www.4clojure.com/problem/34

(ns clojure-drills.4clojure.implement-range-test
  (:use clojure.test
        clojure-drills.core))

(defn ran [s e]
  (if (>= s e)
    []
    (cons s (ran (inc s) e))))

; a different implementation
(defn rang [start end]
  (take (- end start) (iterate inc start)))

(deftest range-test
  (is (= '(1 2 3)
         (ran 1 4))))

(deftest range-test-two
  (is (= '(1 2 3)
         (rang 1 4))))
