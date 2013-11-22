; http://www.4clojure.com/problem/153

(ns clojure-drills.4clojure.pairwise-disjoint-sets-test
  (:use clojure.test
        clojure-drills.core))

(defn pairwise-disjoint? [s]
  (every?
   (fn [[x y]] (empty? (clojure.set/intersection x y)))
   (for [x s
         y s
         :when (not= x y)]
     [x y])))

(deftest two-disjoint-sets-test
  (is (= true
         (pairwise-disjoint? #{#{:a :b} #{:c :d}}))))

(deftest two-joint-sets-test
  (is (= false
         (pairwise-disjoint? #{#{:a :b} #{:c :b}}))))

; learn:
; 1) distinct?
