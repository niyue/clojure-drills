; http://www.4clojure.com/problem/100

(ns clojure-drills.4clojure.least-common-multiple-test
  (:use clojure.test))

(defn lcm [& nums]
  (letfn [(gcd [a b]
            (if (zero? b)
              a
              (gcd b (rem a b))))
          (cm [a b]
            (/ (* a b) (gcd a b)))]
    (reduce cm nums)))

(deftest two-coprime-integer-numbers-lcm-test
  (is (== (lcm 2 3) 6)))

(deftest three-coprime-integer-numbers-lcm-test
  (is (== (lcm 5 3 7) 105)))

(deftest two-rational-numbers-lcm-test
  (is (== (lcm 1/3 2/5) 2)))

(deftest rational-lcm-for-two-rational-numbers-lcm-test
  (is (== (lcm 3/4 1/6) 3/2)))

; learn:
; 1) letfn
; 2) ==
