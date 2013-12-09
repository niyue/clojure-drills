; http://www.4clojure.com/problem/75

(ns clojure-drills.4clojure.euler-toilet-function-test
  (:use clojure.test
        clojure-drills.core))

(defn coprimes [n]
  (letfn [(gcd [a b]
               (if (zero? b)
                 a
                 (gcd b (rem a b))))
          (coprime? [a b] (= 1 (gcd a b)))]
    (count (filter #(coprime? n %) (range 1 (inc n))))))

(deftest euler-toilet-function-for-one-test
    (is (= (coprimes 1) (count '(1)))))

(deftest euler-toilet-function-test
    (is (= (coprimes 10) (count '(1 3 7 9)))))

;(.stackTrace *e)
