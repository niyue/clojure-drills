; http://www.4clojure.com/problem/66

(ns clojure-drills.4clojure.greatest-common-divisor-test
  (:use clojure.test
        clojure-drills.core))

(defn gcd [x y]
   (cond
    (> x y) (let [r (mod x y)]
              (if (zero? r)
                y
                (recur y r)))
    (= x y) x
    :else (recur y x)))

(defn gcd2 [x y]
  (loop [a x
         b y]
    (if (= b 0)
      a
      (recur b (mod a b)))))

(deftest gcd-x-less-than-y-test
  (is (= 2 (gcd 2 4))))

(deftest gcd-two-same-numbers-test
  (is (= 2 (gcd 2 2))))

(deftest gcd-x-bigger-than-y-test
  (is (= 2 (gcd 4 2))))

(deftest gcd-test
  (is (= 6 (gcd 12 30))))

(deftest gcd2-x-less-than-y-test
  (is (= 2 (gcd2 2 4))))
