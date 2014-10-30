; http://www.4clojure.com/problem/61

(ns clojure-drills.4clojure.map-construction-test
  (:use clojure.test
        clojure-drills.core))

(defn mc [k v]
  (reduce
   #(assoc %1 (get %2 0) (get %2 1))
   {}
   (map #(vector %1 %2) k v)))


(defn map-construction [k v]
  (into {} (map #(vector %1 %2) k v)))

(deftest map-construction-test
    (is (= {:a 1, :b 2}
           (mc [:a :b] [1 2]))))

(deftest map-construction-test-two
    (is (= {:a 1, :b 2}
           (map-construction [:a :b] [1 2]))))
