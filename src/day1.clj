(ns day1
  (:require [core :refer [get-puzzle-input]]))

(def puzzle-input (->> (get-puzzle-input 1)
                       (map #(Integer/parseInt %))))

;; part 1
(reduce + puzzle-input)

;; part 2
(loop [input (cycle puzzle-input)
       seen #{}
       freq 0]
  (let [new-freq (+ freq (first input))]
    (if (seen new-freq)
      new-freq
      (recur (rest input)
             (conj seen new-freq)
             new-freq))))

