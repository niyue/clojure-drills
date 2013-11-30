; http://www.4clojure.com/problem/70

(ns clojure-drills.4clojure.word-sorting-test
  (:use clojure.test))

(defn word-sort [s]
  (sort-by clojure.string/lower-case (.split #"\W" s)))

(deftest word-sorting-test
  (is (= (word-sort "Have a nice day.") ["a" "day" "Have" "nice"])))

; learn:
; 1) \W for non word character in regular expression
