; http://www.4clojure.com/problem/78

(ns clojure-drills.4clojure.reimplement-trampoline-test
  (:use clojure.test))

(defn trpl [f & args]
  (loop [r f]
    (if (fn? r)
      (if (empty? args)
        (recur (r args))
        (recur (r [])))
      r)))

(deftest reimplement-trampoline-test
  (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
    (map (partial trpl my-even?) (range 6)))
  [true false true false true false]))
