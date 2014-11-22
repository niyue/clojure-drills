; http://www.4clojure.com/problem/108

(ns clojure-drills.4clojure.lazy-searching-test
  (:use clojure.test))


(defn lazy-search [& colls]
  (loop [cs colls]
    (let [fs (map first cs)
          eq (apply = fs)
          mx (apply max fs)]
      (if eq
        (first (first cs))
        (recur (map (fn [c] (drop-while #(< % mx) c)) cs))))))

(deftest one-coll-test
  (is (= 3 (lazy-search [3 4 5]))))

(deftest two-colls-test
  (is (= 4 (lazy-search [1 2 3 4 5 6 7] [0.5 3/2 4 19]))))

