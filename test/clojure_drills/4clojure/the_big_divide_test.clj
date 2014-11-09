; http://www.4clojure.com/problem/148

(ns clojure-drills.4clojure.the-big-divide-test
  (:use clojure.test
        clojure-drills.core))

(defn big-divide [n a b]
  (letfn [(sum [nums]
               (apply + nums))
          (multiples [m x]
                     (take-while (partial > m)
                                 (iterate (partial + x) x)))
          (multiple-sum [m x]
                        (sum (multiples m x)))]
    (- (+ (multiple-sum n a) (multiple-sum n b))
       (multiple-sum n (* a b)))))

(defn the-big-divide [n a b]
  (let [c (dec n)
        sum (fn [m x]
              (let [y (quot m x)
                    s (/ (*' y (inc y)) 2)]
                (*' s x)))]
    (-' (+' (sum c a) (sum c b)) (sum c (*' a b)))))

(deftest no-qualified-number-test
    (is (= 0 (big-divide 3 17 11))))

(deftest no-qualified-number-test
    (is (= 23 (big-divide 10 3 5))))

(deftest medium-number-test
    (is (= 233168 (big-divide 1000 3 5))))

(deftest number-23-test
    (is (= 23 (the-big-divide 10 3 5))))

(deftest large-number-test
    (is (= "2333333316666668" (str (the-big-divide 100000000 3 5)))))

(deftest interge-overflow-test
    (is (= "110389610389889610389610" (str (the-big-divide (* 10000 10000 10000) 7 11)))))
