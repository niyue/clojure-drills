; http://www.4clojure.com/problem/94

(ns clojure-drills.4clojure.game-of-life-test
  (:use clojure.test
        clojure-drills.core))


(defn tcell [m x y]
  (if (or (>= y (count m)) (>= x (count (first m))) (< y 0) (< x 0)) nil (str (nth (nth m y) x))))

(deftest tcell-test
  (is (= " " (tcell ["      " " ##   "] 0 0))))

(defn game-of-life [m]
  (let [cell (fn [x y] (if (or (>= y (count m)) (>= x (count (first m))) (< y 0) (< x 0)) nil (str (nth (nth m y) x))))
        live? (fn [x y] (= (cell x y) "#"))
        lc (fn [x y] (if (live? x y) 1 0))
        nghb (fn [x y] (apply + (map (partial apply lc) [
                                                 [(- x 1) y]
                                                 [(+ x 1) y]
                                                 [x (- y 1)]
                                                 [x (+ y 1)]
                                                 [(- x 1) (- y 1)]
                                                 [(- x 1) (+ y 1)]
                                                 [(+ x 1) (- y 1)]
                                                 [(+ x 1) (+ y 1)]])))
        nxt (fn [x y]
              (let [live (live? x y)
                    nc (nghb x y)]
                (cond
                  (and live (< nc 2)) " "
                  (and live (< nc 4)) "#"
                  (and live (>= nc 4)) " "
                  (and (not live) (= nc 3)) "#"
                  :else " ")))
        next-row (fn [y row] (apply str (map-indexed (fn [i e] (nxt i y)) row)))]
    (map-indexed (fn [i e] (next-row i e)) m)))

(deftest game-of-life-test
  (is (=
   ["      "
    " ##   "
    " ##   "
    "   ## "
    "   ## "
    "      "] (game-of-life
   ["      "
    " ##   "
    " #    "
    "    # "
    "   ## "
    "      "]))))

; learn:
; unit test small function
; str map will lead to char
