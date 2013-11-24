; http://www.4clojure.com/problem/128

(ns clojure-drills.4clojure.recognize-playing-cards-test
  (:use clojure.test))

(defn parse-card [card]
  (let [s ({\D :diamond, \H :heart, \C :club, \S :spade} (first card))
       r ({\2 0, \3 1, \4 2, \5 3, \6 4, \7 5, \8 6, \9 7, \T 8, \J 9, \Q 10, \K 11, \A 12} (second card))]
   {:suit s, :rank r}))

(deftest recognize-playing-card-test
  (is (= {:suit :diamond :rank 10} (parse-card "DQ"))))

; learn:
; 1) use destructuring to get first/second chars
; 2) zipmap
