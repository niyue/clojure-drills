; http://www.4clojure.com/problem/43

(ns clojure-drills.4clojure.reverse-interleave
  (:require clojure.test))

(defn rev-interleave [coll step]
  (vals (group-by
         #(mod % step)
         coll)))

(deftest reverse-interleave-test
  (is (= '((1 3 5) (2 4 6)) (rev-interleave [1 2 3 4 5 6] 2))))
