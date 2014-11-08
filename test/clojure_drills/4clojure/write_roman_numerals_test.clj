; http://www.4clojure.com/problem/104

(ns clojure-drills.4clojure.write-roman-numerals-test
  (:use clojure.test
        clojure-drills.core))

(defn roman [n]
  (loop [x n
         r ""]
    (if (zero? x)
      r
      (let [nums [["M" 1000] ["CM" 900] ["D" 500] ["CD" 400]
                  ["C" 100]  ["XC" 90]  ["L" 50]  ["XL" 40]
                  ["X" 10]   ["IX" 9]   ["V" 5]   ["IV" 4]
                  ["I" 1]]
            find-first #(first (filter % %2))
            [sym v](find-first #(>= x (second %)) nums)]
        (recur (- x v) (str r sym))))))

(deftest I-test
    (is (= "I" (roman 1))))

(deftest XXX-test
    (is (= "XXX" (roman 30))))

(deftest IV-test
    (is (= "IV" (roman 4))))

(deftest DCCCXXVII-test
    (is (= "DCCCXXVII" (roman 827))))
; learn:
; daowen's solution is similar but more efficient by removing greater symbols during loop

