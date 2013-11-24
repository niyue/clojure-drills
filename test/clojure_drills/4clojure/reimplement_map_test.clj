; http://www.4clojure.com/problem/118

(ns clojure-drills.4clojure.reimplement-map-test
  (:use clojure.test
        clojure-drills.core))

(defn mymap [f coll]
   (if coll
    (cons (f (first coll)) (lazy-seq (mymap f (next coll))))))

(deftest reimplement-map-test
    (is (= (mymap inc [2 3 4 5 6]) [3 4 5 6 7])))

(deftest reimplement-map-infinite-seq-test
    (is (= (take 3 (mymap inc (range))) [1 2 3])))
