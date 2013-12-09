; http://projecteuler.net/problem=4

(ns clojure-drills.project-euler.largest-palindrome-product-test
  (:use clojure.test
        clojure-drills.core))

(defn palindrome? [x]
  (let [s (str x)]
    (= s (clojure.string/reverse s))))

(defn largest-palindrome-product [n]
  (first
    (filter palindrome?
            (sort >
                  (for [i (reverse (range n))
                        j (reverse (range i n))]
                    (* i j))))))

;(largest-palindrome-product 1000)
