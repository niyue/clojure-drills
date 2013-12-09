; http://projecteuler.net/problem=3

(ns clojure-drills.project-euler.biggest-prime-factors-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(defn boolean-vec [x]
  (vec (repeat (inc x) true)))

(defn sieve [is-prime i]
  (let [square (* i i)
        [n1 n2] (split-at square is-prime)
        n (count is-prime)]
    (vec (concat n1
            (map #(if (zero? (mod %2 i)) false %)
                 n2
                 (map #(+ square %) (range n)))))))

(defn primes [n]
  (loop [is-prime (assoc (assoc (boolean-vec n) 0 false) 1 false)
         i 2]
    (cond (> i n)                (filter #(nth is-prime %) (range 2 (inc n)))
          (not (nth is-prime i)) (recur is-prime (inc i))
          :else                  (recur (sieve is-prime i) (inc i)))))


;(primes 10000)
;(apply max (primes (math/sqrt 600851475143)))
