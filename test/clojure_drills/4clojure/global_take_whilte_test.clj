; http://www.4clojure.com/problem/114

(ns clojure-drills.4clojure.global-take-while-test
  (:use clojure.test
        clojure-drills.core))

(defn take-until [n f coll]
  (loop [r n
         remain coll
         result []]
    (if (or (zero? r) (empty? remain))
      (drop-last result)
      (let [fs (first (filter f remain))
            [rfs & rm] (drop-while #(not= % fs) remain)
            efs (take-while #(not= % fs) remain)]
         (recur (dec r) rm (concat result efs [fs]))))))


(deftest take-until-first-test
  (is (= [] (take-until 1 #(= 2 (mod % 3)) [2 3 5 7 11 13 17 19 23]))))

(deftest take-until-two-test
  (is (= [2 3] (take-until 2 #(= 2 (mod % 3)) [2 3 5 7 11 13 17 19 23]))))

(deftest take-until-three-test
  (is (= [2 3 5 7] (take-until 3 #(= 2 (mod % 3)) [2 3 5 7 11 13 17 19 23]))))

(deftest take-until-test
  (is (= [2 3 5 7 11 13] (take-until 4 #(= 2 (mod % 3)) [2 3 5 7 11 13 17 19 23]))))

; learn:
; 1) keep-indexed

