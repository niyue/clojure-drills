; http://www.4clojure.com/problem/55

(ns clojure-drills.4clojure.count-occurences-test
  (:use clojure.test
        clojure-drills.core))

(defn count-occ [coll]
  (let [counts (group-by identity coll)]
    (zipmap (keys counts) (map count (vals counts)))))

(defn count-occurences [coll]
  (let [counts (group-by identity coll)]
    (into {} (for [[k v] counts] [k (count v)]))))

(defn count-occurences-2 [coll]
  (let [counts (group-by identity coll)
        counts-vec (map #(vector (first %) (count (second %))) counts)]
    (into {} counts-vec)))

(deftest count-occurences-test
  (is (= {1 4, 2 2, 3 1} (count-occ [1 1 2 3 2 1 1]))))

(deftest count-occurences-test-two
  (is (= {1 4, 2 2, 3 1} (count-occurences [1 1 2 3 2 1 1]))))

(deftest count-occurences-test-three
  (is (= {1 4, 2 2, 3 1} (count-occurences-2 [1 1 2 3 2 1 1]))))

