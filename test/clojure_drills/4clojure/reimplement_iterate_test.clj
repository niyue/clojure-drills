; http://www.4clojure.com/problem/62

(ns clojure-drills.4clojure.reimplement-iterate-test
  (:use clojure.test
        clojure-drills.core))

(defn new-iterate [f x]
  (lazy-seq
   (cons x (new-iterate f (f x)))))

(deftest inc-iterate-test
  (is (= (take 100 (range 1000)) (take 100 (new-iterate inc 0)))))

; learn
; 1) lazy-seq
