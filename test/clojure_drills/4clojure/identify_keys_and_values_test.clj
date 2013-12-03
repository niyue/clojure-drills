; http://www.4clojure.com/problem/105

(ns clojure-drills.4clojure.identify-keys-and-values-test
  (:use clojure.test
        clojure-drills.core))

(defn vec-map [v]
  (if (seq v)
    (let [[value remaining-vector] (split-with (complement keyword?) (rest v))]
      (assoc (vec-map remaining-vector) (first v) value))
    {}))

(deftest single-key-value-test
    (is (= (vec-map [:a 1]) {:a [1]})))
