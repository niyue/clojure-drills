; http://www.4clojure.com/problem/115

(ns clojure-drills.4clojure.the-balance-of-n-test
  (:use clojure.test
        clojure-drills.core))

(defn balanced? [n]
  (let [digits (str n)
        dsum #(reduce + (map int %))
        half (/ (count digits) 2)]
    (= (dsum (subs digits 0 half))
       (dsum (subs digits (+ half 1/2))))))

(deftest double-digit-balance-number-test
    (is (= (balanced? 11) true)))

(deftest single-digit-balance-number-test
    (is (= (balanced? 1) true)))

(deftest triple-digit-balance-number-test
    (is (= (balanced? 121) true)))

(deftest unbalance-number-test
    (is (= (balanced? 88099) false)))

(deftest balance-number-test
    (is (= (balanced? 89098) true)))

; learn:
; 1) (subs "12" 1 2) => "2"
; 2) (take 1 "12") => (\1)
