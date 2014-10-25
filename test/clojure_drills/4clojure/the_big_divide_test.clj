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

(deftest no-qualified-number-test
    (is (= 0 (big-divide 3 17 11))))

(deftest no-qualified-number-test
    (is (= 23 (big-divide 10 3 5))))

(deftest medium-number-test
    (is (= 233168 (big-divide 1000 3 5))))

(deftest large-number-test
    (is (= "2333333316666668" (str (big-divide 100000000 3 5)))))
