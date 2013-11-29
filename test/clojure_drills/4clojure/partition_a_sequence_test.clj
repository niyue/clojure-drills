; http://www.4clojure.com/problem/80

(ns clojure-drills.4clojure.partition-a-sequence-test
  (:use clojure.test
        clojure-drills.core))

(defn partition-seq [n coll]
  (partition-by
    #(quot % n)
    (take
     (* (quot (count coll) n) n)
     coll)))

(defn partition-seq-2 [n coll]
  (let [p (partition-by #(quot % n) coll)]
    (if (zero? (mod (count coll) n))
      p
      (drop-last p))))

(deftest partition-seq-test
  (is (= (partition-seq 3 (range 8)) '((0 1 2) (3 4 5)))))

(deftest partition-seq-2-test
  (is (= (partition-seq-2 3 (range 8)) '((0 1 2) (3 4 5)))))

