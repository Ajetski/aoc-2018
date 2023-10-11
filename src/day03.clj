(ns ^{:doc "Day 3: No Matter How You Slice It"
      :author "Adam Jeniski"}
 day03 (:require [core :refer [get-puzzle-input]]))

(defn parse-line [line]
  (let [[id x y w h] (->> (re-find #"^#(\d+) @ (\d+),(\d+): (\d+)x(\d+)$" line)
                          rest
                          (map #(Integer/parseInt %)))]
    {:id id, :x x, :y y, :width w, :height h}))

(def puzzle-input (->> (get-puzzle-input 3)
                       (map parse-line)))

(defn get-coords [{x :x
                   y :y
                   w :width
                   h :height}]
  (for [x-offset (range w)
        y-offset (range h)]
    {:x (+ x x-offset)
     :y (+ y y-offset)}))

;; part 1
(->> puzzle-input
     (reduce (fn [acc curr]
               (merge-with +
                           acc
                           (->> (get-coords curr)
                                (map #(vector % 1))
                                (into {}))))
             {})
     (filter #(> (second %) 1))
     (count))

;; part 2
(let [claims (reduce (fn [acc curr]
                       (merge-with +
                                   acc
                                   (->> (get-coords curr)
                                        (map #(vector % 1))
                                        (into {}))))
                     {}
                     puzzle-input)]
  (reduce (fn [_ curr]
            (when (every? #(= 1 (claims %)) (get-coords curr))
              (reduced (:id curr))))
          puzzle-input))

