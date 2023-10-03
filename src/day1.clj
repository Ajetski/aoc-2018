(ns day1
  (:require [core :refer [get-puzzle-input]]))

;; part 1
(->> (get-puzzle-input 1)
     (map #(Integer/parseInt %))
     (reduce +))

;; part 2
(loop [input (->> (get-puzzle-input 1)
                  (map #(Integer/parseInt %))
                  cycle)
       seen #{}
       freq 0]
  (let [new-freq (+ freq (first input))]
    (if (seen new-freq)
      new-freq
      (recur (rest input)
             (conj seen new-freq)
             new-freq))))

