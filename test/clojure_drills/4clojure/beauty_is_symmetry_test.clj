; http://www.4clojure.com/problem/96

(ns clojure-drills.4clojure.beauty-is-symmetry
  (:use clojure.test
        clojure-drills.core))


(defn sym?
  ([tree]
    (or
      (nil? tree)
      (sym? (second tree) (second (rest tree)))))
  ([l r]
    (or
      (and
        (nil? l)
        (nil? r))
      (and
       (= (first l) (first r))
       (sym? (second l) (second (rest r)))
       (sym? (second (rest l)) (second r))))))

(deftest symmetric-nil-tree
    (is (= true
           (sym? nil))))

(deftest symmetric-root-only-tree
    (is (= true
           (sym? '(:a)))))

(deftest symmetric-tree
    (is (= true
           (sym? '(:a (:b nil nil) (:b nil nil))))))

(deftest insymmetric-tree
    (is (= false
           (sym? '(:a (:b nil nil) nil)))))
