; http://www.4clojure.com/problem/32

(ns clojure-drills.4clojure.duplicate_a_sequence_test
  (:use clojure.test
        clojure-drills.core))


(deftest set-function
  (testing "use set as a function will return element itself instead of a boolean value"
    (is (= 7 (#{2 7 6} 7)))))

(deftest duplicate-a-sequence
  (is (= [1 1 2 2 3 3]
         (#(interleave % %) [1 2 3]))))

;(interleave [1 2 3] [1 2 3])
;(apply concat (map #(list % %) [1 2 3]))
;(mapcat #list(% %) [1 2 3])

; learn:
; 1) usage of `repeat`: mapcat #(repeat 2 %)
; 2) usage of `interleave`
