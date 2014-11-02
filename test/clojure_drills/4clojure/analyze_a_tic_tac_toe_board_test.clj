; http://www.4clojure.com/problem/73

(ns clojure-drills.4clojure.analyze-a-tic-tac-toe-board-test
  (:use clojure.test))

; a solution only works for 3x3 board
(defn analyze [[[a1 a2 a3][b1 b2 b3][c1 c2 c3]]]
  (let [win? (fn [[a & coll]]
                (if (every? #(and (= a %) (not= a :e)) coll) a))]
    (or (win? [a1 a2 a3]) (win? [b1 b2 b3]) (win? [c1 c2 c3])
        (win? [a1 b1 c1]) (win? [a2 b2 c2]) (win? [a3 b3 c3])
        (win? [a1 b2 c3]) (win? [a3 b2 c1]))))

(deftest all-empty-test
  (is (= nil (analyze [[:e :e :e]
                       [:e :e :e]
                       [:e :e :e]]))))

(deftest x-wins-test
  (is (= :x (analyze [[:x :e :o]
                       [:x :e :e]
                       [:x :e :o]]))))
