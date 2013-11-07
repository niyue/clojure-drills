; http://www.4clojure.com/problem/48

(ns clojure-drills.4clojure.intro-to-some-test
  (:use clojure.test
        clojure-drills.core))

(deftest some-set
  (testing "some-with-a-set"
    (is (= 6 (some #{2 7 6} [5 6 7 8])))))

(deftest set-function
  (testing "use set as a function will return element itself instead of a boolean value"
    (is (= 7 (#{2 7 6} 7)))))
