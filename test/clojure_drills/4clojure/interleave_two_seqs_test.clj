; http://www.4clojure.com/problem/39

(ns clojure-drills.4clojure.interleave-two-seqs-test
  (:use clojure.test
        clojure-drills.core))

(deftest interleave-two-seqs
    (is (=
         '(1 :a 2 :b 3 :c)
         ((fn intl [c1 c2]
           (apply concat (map #(list %1 %2) c1 c2))) [1 2 3] [:a :b :c]))))




