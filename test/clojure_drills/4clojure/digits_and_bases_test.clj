; http://www.4clojure.com/problem/137

(ns clojure-drills.4clojure.digits-and-bases-test
  (:use clojure.test
        clojure-drills.core))

(conj [1 2] 3)

(defn digits [n b]
  (loop [r n
         d []]
    (if (zero? r)
      (if (empty? d) [0] d)
      (recur (mod r b) (conj d (quot r b))))))

(deftest base-10-test
  (is (= [1 2 3] (digits 123 10))))

(deftest zero-test
  (is (= [0] (digits 0 11))))

(deftest binary-test
  (is (= [1 0 0 1] (digits 9 2))))
