; http://www.4clojure.com/problem/79

(ns clojure-drills.4clojure.triangle-minimal-path-test
  (:use clojure.test))

(defn triangle-min [triangle]
  (loop [t triangle]
    (if (= 1 (count t))
      (first (first t))
      (let [lr (last t)
            slr (last (drop-last t))
            minrow (map-indexed #(min %2 (nth lr (inc %))) (drop-last lr))
            sum (vec (map + slr minrow))]
         (recur (concat (drop-last 2 t) [sum])))
      )))


(deftest triangle-minimal-single-row-test
  (= 3 (triangle-min
          '([3]))))

(deftest triangle-minimal-two-rows-test
  (= 5 (triangle-min
          '([3]
           [2 4]))))

(deftest triangle-minimal-three-rows-test
  (= 6 (triangle-min
          '([3]
           [2 4]
          [1 9 3]))))

(deftest triangle-minimal-four-rows-test
  (= 12 (triangle-min
          '([3]
           [2 4]
          [1 9 3]
         [9 9 2 4]))))

(deftest triangle-minimal-test
  (= 7 (triangle-min
         '([1]
          [2 4]
         [5 1 4]
        [2 3 4 5]))))


(deftest triangle-minimal-test-two
  (= 20 (triangle-min
          '([3]
           [2 4]
          [1 9 3]
         [9 9 2 4]
        [4 6 6 7 8]
       [5 7 3 5 1 4]))))
