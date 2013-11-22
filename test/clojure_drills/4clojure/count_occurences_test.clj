; http://www.4clojure.com/problem/55

(ns clojure-drills.4clojure.count-occurences-test
  (:use clojure.test
        clojure-drills.core))

(defn count-occ [coll]
  (let [counts (group-by identity coll)]
    (zipmap (keys counts) (map count (vals counts)))))

(deftest count-occurences-test
  (is (= {1 4, 2 2, 3 1} (count-occ [1 1 2 3 2 1 1]))))
