; http://www.4clojure.com/problem/95

(ns clojure-drills.4clojure.to-tree-or-not-to-tree-test
  (:use clojure.test
        clojure-drills.core))


(defn tree? [node]
  (if (coll? node)
    (and
     (= 3 (count node))
     (reduce #(and %1 (tree? %2)) true node))
    (not= node false)))

(deftest single-node-is-not-tree-test
    (is (= false
           (tree? [:a]))))

(deftest three-nodes-is-tree-test
    (is (= true
           (tree? [:a nil nil]))))

(deftest tree-with-false-node-test
    (is (= false
           (tree? [1 [2 [3 [4 false nil] nil] nil] nil]))))

; http://www.4clojure.com/problem/solutions/95
; learn: use every? instead of reduce
