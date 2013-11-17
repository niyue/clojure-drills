; http://www.4clojure.com/problem/97

(ns clojure-drills.4clojure.pascal-triangle-test
  (:use clojure.test
        clojure-drills.core))

(let [x '(1 1)]
  (map #(+ % %2) (cons 0 x) (conj x 0)))

(defn pascal-triangle [n]
  (nth
   (iterate (fn [x]
              (vec (map #(+ % %2)
                (cons 0 x)
                (conj x 0)))) [1])
   (dec n)))

(deftest first-pascal-triangle-test
    (is (= [1]
           (pascal-triangle 1))))

(deftest second-pascal-triangle-test
    (is (= [1 1]
           (pascal-triangle 2))))

(deftest third-pascal-triangle-test
    (is (= [1 2 1]
           (pascal-triangle 3))))
