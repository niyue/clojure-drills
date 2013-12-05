; http://www.4clojure.com/problem/177

(ns clojure-drills.4clojure.balancing-brackets-test
  (:use clojure.test
        clojure.set))

; reduced function is added after Clojure 1.5
(defn balanced? [s]
  (let [open #{\(, \{, \[}
        close #{\), \}, \]}
        all (clojure.set/union open close)
        bm (zipmap open close)
        brackets (filter all s)]
    (empty?
      (reduce
       #(cond
         (open %2) (conj % %2)
         :else
           (if (or (empty? %) (not= (bm (peek %)) %2))
             (reduced (conj % %2))
             (pop %)))
       ()
       brackets))))

; an implementation doesn't use reduced function
(defn slow-balanced? [s]
  (let [open #{\(, \{, \[}
        close #{\), \}, \]}
        all (clojure.set/union open close)
        bm (zipmap open close)
        brackets (filter all s)]
    (empty?
      (reduce
       #(cond
         (open %2) (conj % %2)
         :else
           (if (or (empty? %) (not= (bm (peek %)) %2))
             (conj % %2)
             (pop %)))
       ()
       brackets))))

(deftest balanced-single-parenthesis-test
  (is (= (balanced? "()") true)))

(deftest close-more-unbalanced-single-parenthesis-test
  (is (= (balanced? ")(()") false)))

(deftest open-more-unbalanced-single-parenthesis-test
  (is (= (balanced? "(()") false)))

(deftest balanced-single-brackets-test
  (is (= (balanced? "[]") true)))

(deftest mixed-balanced-single-brackets-test
  (is (= (balanced? "()[]") true)))

(deftest nested-mixed-balanced-single-brackets-test
  (is (= (balanced? "([])") true)))

(deftest complex-mixed-unbalanced-single-brackets-test
  (is (= (balanced? "(}{[])") false)))

(deftest complex-mixed-unbalanced-single-brackets-test
  (is (= (balanced? "[{]}") false)))
