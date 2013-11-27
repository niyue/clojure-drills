; http://www.4clojure.com/problem/77

(ns clojure-drills.4clojure.anagram-finder-test
  (:use clojure.test
        clojure-drills.core))

(defn group-anagram [s]
  (set (filter
        #(>= (count %) 2)
        (map set (vals (group-by #(sort %) s))))))

(deftest anagram-finder-test
    (is (= (group-anagram ["meat" "mat" "team" "mate" "eat"]) #{#{"meat" "team" "mate"}})))
