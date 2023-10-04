(ns ^{:doc "Day 3: No Matter How You Slice It"
      :author "Adam Jeniski"}
 day3 (:require [core :refer [get-puzzle-input]]))

(defn parse-line [line]
  (let [[id x y w h] (->> (re-find #"^#(\d+) @ (\d+),(\d+): (\d+)x(\d+)$" line)
                          rest
                          (map #(Integer/parseInt %)))]
    {:id id, :x x, :y y, :width w, :height h}))

(def puzzle-input (->> (get-puzzle-input 3)
                       (map parse-line)))

;; part 1
(prn puzzle-input)

