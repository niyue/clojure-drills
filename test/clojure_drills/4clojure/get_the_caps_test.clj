; http://www.4clojure.com/problem/29

(ns clojure-drills.4clojure.get-the-caps-test
  (:use clojure.test
        clojure-drills.core))


(deftest seq-string
  (testing "seqenize a string"
    (is (= [\a] (seq "a")))))

(deftest get-the-caps
  (is (= "ADB"
         ((fn [s]
           (apply str (filter #(Character/isUpperCase %) s)))
          "AcDB"))))
