; http://projecteuler.net/problem=11

(ns clojure-drills.project-euler.highly-divisible-triangular-number-test
  (:require [clojure.math.numeric-tower :as math])
  (:use clojure.test
        clojure-drills.core))

(def primes [2 3 5 7 11 13 17 19 23 29
31 37 41 43 47 53 59 61 67 71
73 79 83 89 97 101 103 107 109 113
127 131 137 139 149 151 157 163 167 173
179 181 191 193 197 199 211 223 227 229
233 239 241 251 257 263 269 271 277 281
283 293 307 311 313 317 331 337 347 349
353 359 367 373 379 383 389 397 401 409
419 421 431 433 439 443 449 457 461 463
467 479 487 491 499 503 509 521 523 541])

(defn sum [x]
  (/ (* (+ 1 x) x) 2))

(defn triangular-numbers []
  (map sum (iterate inc 1)))

(defn slow-factors [x]
  (filter #(zero? (rem x %)) (range 1 (inc x))))

(defn factor-pow [x prime]
  (loop [c 0 n x]
    (if (not= 0 (mod n prime))
      c
      (recur (inc c) (/ n prime)))))

(defn factor-product [factor-count]
  (reduce * (map inc factor-count)))

(defn factor-count [x primes]
  (factor-product (map #(factor-pow x %) primes)))


(first (drop-while #(<= (factor-count % primes) 500)
            (triangular-numbers)))
