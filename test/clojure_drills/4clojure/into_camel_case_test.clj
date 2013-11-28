; http://www.4clojure.com/problem/102

(ns clojure-drills.4clojure.into-camel-case-test
  (:use clojure.test
        clojure-drills.core))

(defn camelize [s]
  (let [[a & xs] (.split #"-" s)]
    (apply str a (map clojure.string/capitalize xs))))

(deftest into-camel-case
    (is (= (camelize "multi-word-key") "multiWordKey")))
