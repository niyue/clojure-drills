; http://www.4clojure.com/problem/41

(ns clojure-drills.4clojure.drop-every-nth-item-test
  (:use clojure.test
        clojure-drills.core))

zero? (mod 10 3)

(defn drop-nth [coll n]
   (map second (filter
    #(not (zero? (mod (inc (first %)) n)))
    (map #(list % %2) (range) coll))))

(deftest drop-every-nth-item-test
  (is (= [1 2 4 5 7 8]
         (drop-nth [1 2 3 4 5 6 7 8] 3))))
