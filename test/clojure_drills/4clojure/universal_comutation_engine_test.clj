; http://www.4clojure.com/problem/121

(ns clojure-drills.4clojure.universal-computation-engine-test
  (:use clojure.test
        clojure-drills.core))

(defn compute [fl]
  (fn [m]
    (let [[op & args]
          (map
           #(cond
             (seq? %) ((compute %) m)
             (m %) (m %)
             :else %)
           fl)]
      (apply (resolve op) args))))

(deftest compute-test
    (is (= 2 ((compute '(/ a b)) '{b 8 a 16}))))


(= (class /) (first '(/)))
(class /)

(apply (resolve (first '(/))) '(16 8))
