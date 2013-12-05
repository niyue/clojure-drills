; http://www.4clojure.com/problem/67

(ns clojure-drills.4clojure.prime-numbers-test
  (:use clojure.test))

(defn primes [n]
  (take n
        (filter (fn [x]
                  (not-any?
                   #(zero? (rem x %))
                   (range 2 x)))
                (drop 2 (range)))))

(deftest first-two-prime-numbers-test
  (is (= (primes 2) [2 3])))
