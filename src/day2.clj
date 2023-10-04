(ns ^{:doc "Day 2: Inventory Management System"
      :author "Adam Jeniski"}
 day2 (:require [core :refer [get-puzzle-input]]
                [clojure.set :refer [union]]))

(def puzzle-input (get-puzzle-input 2))

;; part 1
(->> puzzle-input
     (reduce (fn [acc word]
               (let [counts (-> word frequencies vals frequencies)]
                 (-> acc
                     (update :two   #(if (counts 2) (inc %) %))
                     (update :three #(if (counts 3) (inc %) %)))))
             {:two 0, :three 0})
     vals
     (apply *))

;; part 2
(reduce (fn [seen word]
          (let [substrs (->> (range (count word))
                             (map #(str (subs word 0 %) (subs word (inc %))))
                             (into #{}))]
            (or (some-> (some seen substrs) reduced)
                (union seen substrs))))
        #{}
        puzzle-input)
