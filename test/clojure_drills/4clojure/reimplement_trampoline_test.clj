; http://www.4clojure.com/problem/78

(ns clojure-drills.4clojure.reimplement-trampoline-test
  (:use clojure.test))

(defn trpl [f & args]
  (loop [r f
         params args]
    (if (fn? r)
      (if (nil? params)
        (recur (r) args)
        (recur (r args) nil))
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
