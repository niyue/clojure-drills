; http://www.4clojure.com/problem/23

(ns clojure-drills.4clojure.reverse-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn rev [coll]
  (loop [r []
         c coll]
    (if (seq c)
      (recur (concat [(first c)] r) (rest c))
      r)))

(deftest reverse-test
    (is (= [1 2 3] (rev [3 2 1]))))

; learn:
; 1) how to append an element into the end of a sequence `concat coll [e]`
; 2) use list () for reversion (like a stack)
