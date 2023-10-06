(ns ^{:doc "Day 1: Chronal Calibration"
      :author "Adam Jeniski"}
 day01 (:require [core :refer [get-puzzle-input]]))

(def nums (->> (get-puzzle-input 1)
                       (map #(Integer/parseInt %))))

;; part 1
(reduce + nums)

;; part 2
(loop [input (cycle nums)
       seen #{}
       freq 0]
  (let [new-freq (+ freq (first input))]
    (if (seen new-freq)
      new-freq
      (recur (rest input)
             (conj seen new-freq)
             new-freq))))

