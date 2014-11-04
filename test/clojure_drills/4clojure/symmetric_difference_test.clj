; http://www.4clojure.com/problem/88

(ns clojure-drills.4clojure.symmetric-difference-test
  (:use clojure.test
        clojure-drills.core))

(defn diff [a b]
  (set (let [u (clojure.set/union a b)
        i (clojure.set/intersection a b)]
    (filter #(not (contains? i %)) u))))

(defn diff-2 [a b]
  (let [u (clojure.set/union a b)
        i (clojure.set/intersection a b)]
    (clojure.set/difference u i)))

(deftest symmetric-differecen-test
    (is (= (diff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})))

(deftest symmetric-differecen-test-two
    (is (= (diff-2 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})))

; learn:
; 1) complement
; 2) disj
