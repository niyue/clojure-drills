; http://www.4clojure.com/problem/74

(ns clojure-drills.filter-perfect-squares-test
  (:use clojure.test
        clojure-drills.core))

(defn filter-square [nums]
  (clojure.string/join
   ","
   (let [coll (clojure.string/split nums #",")]
     (filter
      #(let [n (Integer/valueOf %)
             r (Math/sqrt n)]
          (== r (int r)))
      coll))))

(deftest filter-perfect-squares-test
  (is (= (filter-square "4,5,6,7,8,9") "4,9")))

; learn:
; 1) (rem 2.5 1) => 0.5
; 2) (== 3.0 3) => true; (= 3.0 3) => false
