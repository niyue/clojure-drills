; http://www.4clojure.com/problem/85

(ns clojure-drills.4clojure.power-set-test
  (:use clojure.test
        clojure-drills.core))

(defn power-set [s]
  (let [len (bit-shift-left 1 (count s))
        m (zipmap (range) (vec s))]
    (set
     (map
      (fn [i] (set (vals (filter #(bit-test i (% 0)) m))))
      (range len)))))

(deftest power-set-test
    (is (= (power-set #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})))
