; http://www.4clojure.com/problem/44

(ns clojure-drills.4clojure.rotate-sequence-test
  (:require clojure.test))

(defn rotate [r c]
  (let [s (mod r (count c))]
   (concat (drop s c) (take s c))))

(deftest rotate-seq-test
  (is (= '(3 4 5 1 2) (rotate 2 [1 2 3 4 5]))))
