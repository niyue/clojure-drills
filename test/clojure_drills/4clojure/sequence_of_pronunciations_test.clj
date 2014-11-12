; http://www.4clojure.com/problem/110

(ns clojure-drills.4clojure.sequence-of-pronunciations-test
  (:use clojure.test
        clojure-drills.core))

(defn pronounce [coll]
  (let [p (fn [c]
            (mapcat #(vector (count %) (first %)) (partition-by identity c)))]
    (rest (iterate p coll))))

(deftest three-one-two-four-test
    (is (= [3 1 2 4] (first (pronounce [1 1 1 4 4])))))

