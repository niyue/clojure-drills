; http://www.4clojure.com/problem/102

(ns clojure-drills.4clojure.into-camel-case-test
  (:use clojure.test
        clojure-drills.core))

(defn camelize [s]
  (let [[a & xs] (.split #"-" s)]
    (apply str a (map clojure.string/capitalize xs))))

(defn which-coll [c]
  (cond
    (reversible? c) :vector
    (associative? c) :map
    (ifn? c) :set
    :else :list))

(deftest which-collection-test
    (is (= [:map :set :vector :list] (map which-coll [{} #{} [] ()]))))

; learn:
; 1) counted? reversible? associative? ifn? sequential?
