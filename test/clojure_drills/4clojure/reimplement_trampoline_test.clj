; http://www.4clojure.com/problem/78

(ns clojure-drills.4clojure.reimplement-trampoline-test
  (:use clojure.test))

; iterative implementation
(defn trpl [f & args]
  (let [r (apply f args)]
    (loop [rf r]
      (if (fn? rf)
        (recur (rf))
        rf))))

; recursive implementation
(defn tram [f & args]
  (let [r (apply f args)]
    (if (fn? r)
      (tram r)
      r)))

(deftest reimplement-trampoline-calc-test
  (= (letfn [(triple [x] #(sub-two (* 3 x)))
          (sub-two [x] #(stop?(- x 2)))
          (stop? [x] (if (> x 50) x #(triple x)))]
       (trpl triple 2))
     82))

(deftest reimplement-trampoline-myeven-test
  (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
       (map (partial trpl my-even?) (range 6)))
     [true false true false true false]))

; learn:
; 1) use %& to represent optional function argument
