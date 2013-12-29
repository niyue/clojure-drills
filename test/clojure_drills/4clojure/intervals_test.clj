; http://www.4clojure.com/problem/171

(ns clojure-drills.4clojure.intervals-test
  (:use clojure.test
        clojure-drills.core))

(defn intervals [v]
  (let [nums (sort (distinct v))]
    (if (= (count nums) 1)
      [(first nums) (last nums)]
      (map #(vector (first (first %)) (last (last %)))
           (filter #(= 1 (- (last (first %)) (first (first %))))
                   (partition-by #(- (last %) (first %))
                                 (partition 2 1 nums)))))))

(deftest single-intervals-test
    (is (= (intervals [1 2 3]) [[1 3]])))

(deftest two-intervals-test
    (is (= (intervals [10 9 8 1 2 3]) [[1 3] [8 10]])))

(deftest all-same-numbers-intervals-test
    (is (= (intervals [1 1 1]) [[1 1]])))

(deftest single-number-interval-test
    (is (= (intervals [1 2 3 5]) [[1 3] [5 5]])))

(deftest single-number-in-the-middle-interval-test
    (is (= (intervals [1 2 3 5 9 10]) [[1 3] [5 5] [9 10]])))
