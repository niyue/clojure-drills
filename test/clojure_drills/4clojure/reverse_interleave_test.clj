; http://www.4clojure.com/problem/43

(ns clojure-drills.4clojure.reverse-interleave-test
  (:use clojure.test))

(defn rev-interleave [coll step]
  (vals (group-by
         #(mod % step)
         coll)))

; an implementation that can be applied to more general cases
(defn reverse-interleave [coll step]
  (let [c (map list coll (range))]
    (map #(map first %) (vals (group-by #(mod (second %) step) c)))))


(deftest rev-interleave-test
  (= '((1 3 5) (2 4 6)) (rev-interleave [1 2 3 4 5 6] 2)))

(deftest reverse-interleave-test
  (= '((1 3 5) (2 4 6)) (reverse-interleave [1 2 3 4 5 6] 2)))

; learn:
; 1) `apply map list` to more than one collections
; 2) group-by
