; http://www.4clojure.com/problem/74

(ns clojure-drills.4clojure.filter-perfect-squares-test
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

(defn squares [string]
  (let [coll (clojure.string/split string #",")
        nums (map #(Integer/valueOf %) coll)
        square-nums (filter
                     #(let [s (int (Math/sqrt %))] (= % (* s s))) nums)]
    (clojure.string/join "," square-nums)))

(deftest filter-perfect-squares-test
  (is (= (filter-square "4,5,6,7,8,9") "4,9")))

(deftest filter-perfect-squares-test-two
  (is (= (squares "4,5,6,7,8,9") "4,9")))

; learn:
; 1) (rem 2.5 1) => 0.5
; 2) (== 3.0 3) => true; (= 3.0 3) => false
