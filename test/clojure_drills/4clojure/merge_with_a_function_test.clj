; http://www.4clojure.com/problem/69

(ns clojure-drills.4clojure.merge-with-a-function-test
  (:use clojure.test
        clojure-drills.core))

(defn merge-map [f & maps]
  (let [ks (set (reduce concat #{} (map keys maps)))]
    (zipmap ks
      (map #(let [vs (filter identity (map (fn [m] (m %)) maps))]
            (if (= 1 (count vs))
              (first vs)
              (apply f vs)))
         ks))))

(defn merge-use [f & maps]
  (let [key-set (reduce #(into % (keys %2)) #{} maps)]
    (zipmap key-set (map (fn [k] (apply f (filter identity (reduce #(conj % (%2 k)) [] maps)))) key-set))))

(deftest merge-all-map
  (is (= (merge-map * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5}) {:a 4, :b 6, :c 20})))

(deftest merge-minus-map
  (is (= (merge-map - {1 10, 2 20} {1 3, 2 10, 3 15}) {1 7, 2 10, 3 15})))

(deftest merge-use-all-map
  (is (= (merge-use * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5}) {:a 4, :b 6, :c 20})))

; learn:
; 1) zipmap
