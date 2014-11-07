; http://www.4clojure.com/problem/92

(ns clojure-drills.4clojure.read-roman-numeral-test
  (:use clojure.test
        clojure-drills.core))

(defn roman [s]
  (loop [[c & r] s
         n 0]
    (let [t (str c (first r))
          m (drop 1 r)
          f (str c)]
      (if c
        (cond
          (= f "M" ) (recur r (+ n 1000))
          (= f "D" ) (recur r (+ n 500))
          (= t "CM") (recur m (+ n 900))
          (= t "CD") (recur m (+ n 400))
          (= f "C" ) (recur r (+ n 100))
          (= f "L" ) (recur r (+ n 50))
          (= t "XC") (recur m (+ n 90))
          (= t "XL") (recur m (+ n 40))
          (= f "X" ) (recur r (+ n 10))
          (= f "V" ) (recur r (+ n 5))
          (= t "IX") (recur m (+ n 9))
          (= t "IV") (recur m (+ n 4))
          (= f "I" ) (recur r (+ n 1)))
        n))))

(deftest XIV-test
    (is (= 14 (roman "XIV"))))

(deftest DCCCXXVII-test
    (is (= 827 (roman "DCCCXXVII"))))

; learn:
; 1) destructing a string will get char instead of substring


