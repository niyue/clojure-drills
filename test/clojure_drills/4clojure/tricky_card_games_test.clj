; http://www.4clojure.com/problem/141

(ns clojure-drills.4clojure.tricky-card-games-test
  (:use clojure.test))

(defn card-game [trump]
  (fn [cards]
    (let [ts (or trump (:suit (first cards)))]
      (apply max-key (fn [{s :suit r :rank}] (if (= ts s) (+ 13 r) r)) cards))))

(deftest notrump-test
  (is (= {:suit :club :rank 9}  ((card-game nil) [{:suit :club :rank 4}
                                                  {:suit :club :rank 9}]))))

; learn:
; 1) max-key usage
