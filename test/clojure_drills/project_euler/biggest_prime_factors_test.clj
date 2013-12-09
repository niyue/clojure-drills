; http://projecteuler.net/problem=3

(ns clojure-drills.project-euler.biggest-prime-factors-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(defn boolean-vec [x]
  (vec (repeat (inc x) true)))

(defn slow-sieve [is-prime i]
  (let [square (* i i)
        [n1 n2] (split-at square is-prime)
       n (count is-prime)]
    (vec (concat n1
            (map #(if (zero? (mod %2 i)) false %)
                 n2
                 (map #(+ square %) (range n)))))))

(defn slow-primes [n]
  (loop [is-prime (assoc (assoc (boolean-vec n) 0 false) 1 false)
         i 2]
    (cond (> i n)                (filter #(nth is-prime %) (range 2 (inc n)))
          (not (nth is-prime i)) (recur is-prime (inc i))
          :else                  (recur (slow-sieve is-prime i) (inc i)))))

; eratosthenes prime sieve
(defn sieve [n]
  (let [p (transient (boolean-vec n))]
    (assoc! p 0 false)
    (assoc! p 1 false)
    (doseq [i (range 2 (inc n))
            j (range (* i i) (inc n))
            :when (and (p i) (zero? (mod j i)))]
      (assoc! p j false))
    (persistent! p)))

(defn primes [n]
  (let [p (sieve n)]
    (filter p (range 2 (inc n)))))

(defn max-prime-factor [n]
  (apply max (filter #(zero? (mod n %)) (primes (math/sqrt n)))))

;(max-prime-factor 600851475143)


(comment
(time
  (dotimes [i 10]
    (doall (slow-primes 1000))))

; 10+ times faster
(time
  (dotimes [i 10]
    (doall (primes 1000))))
)
;(primes 10000)
;(apply max (primes (math/sqrt 600851475143)))

; learn:
; 1) transient data structure
; 2) doseq
