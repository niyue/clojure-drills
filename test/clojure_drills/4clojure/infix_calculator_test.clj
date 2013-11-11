; http://www.4clojure.com/problem/135

(ns clojure-drills.4clojure.infix-calculator-test
  (:use clojure.test
        clojure-drills.core))

(defn infix-calc [& ops]
  (if (= 1 (count ops))
    (first ops)
    (apply infix-calc
     (cons
      ((second ops) (first ops) (nth ops 2))
      (drop 3 ops)))))

(deftest infix-calculator-single-op-test
    (is (= 2
           (infix-calc 2))))

(deftest infix-calculator-test
    (is (= 7
           (infix-calc 2 + 5))))

(deftest infix-calculator--division-test
    (is (= 42
           (infix-calc 38 + 48 - 2 / 2))))

; http://www.4clojure.com/problem/solutions/135
; see daowen's solution for binding variant number of arguments
