; http://www.4clojure.com/problem/63

(ns clojure-drills.4clojure.group-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn group [f coll]
  (reduce #(assoc % (f %2) (concat (% (f %2)) (vector %2))) {} coll))

(defn grp [f coll]
  (reduce #(assoc % (f %2) (conj (vec (% (f %2))) %2)) {} coll))

(deftest group-a-sequence-test
    (is (= (group #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})))

(deftest group-a-sequence-test
    (is (= (grp #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})))

; learn:
; 1) merge-with
