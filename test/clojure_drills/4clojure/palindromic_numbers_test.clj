; http://www.4clojure.com/problem/150

(ns clojure-drills.4clojure.palindromic-numbers-test
  (:use clojure.test))


((fn [x] (= (str x) (clojure.string/reverse (str x)))) 101)

(defn palindromics [n]
  (let [palindrome? (fn [x] (= (str x) (clojure.string/reverse (str x))))]
    (filter palindrome? (iterate inc n))))
; TODO: use integer = palindrome integer to determine

(deftest above-0-test
  (is (= [0 1 2 3 4 5 6 7 8 9
    11 22 33 44 55 66 77 88 99
    101 111 121 131 141 151 161] (take 26 (palindromics 0)))))

(deftest above-1234550000-test
  (is (= [1234554321 1234664321 1234774321
    1234884321 1234994321 1235005321] (take 6 (palindromics 1234550000)))))

(deftest nth-test
  (is (= 9102019 (nth (palindromics 0) 10101))))

(deftest above-9999999-test
  (is (= true (apply < (take 6666 (palindromics 9999999))))))
