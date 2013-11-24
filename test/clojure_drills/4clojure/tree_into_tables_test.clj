; http://www.4clojure.com/problem/146

(ns clojure-drills.4clojure.tree-into-tables-test
  (:use clojure.test
        clojure-drills.core))

(defn tree2table [m]
  (into {}
        (for [k1 (keys m)
              k2 (keys (m k1))]
          [(vector k1 k2) ((m k1) k2)])))

(deftest tree-into-tables-test
    (is (= (tree2table '{a {p 1, q 2} b {m 3, n 4}})
           '{[a p] 1, [a q] 2, [b m] 3, [b n] 4})))

; learn:
; 1) map entry destructuring
