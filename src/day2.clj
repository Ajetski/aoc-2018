(ns ^{:doc "Day 2: Inventory Management System"
      :author "Adam Jeniski"}
 day2 (:require [core :refer [get-puzzle-input]]
                [clojure.set :refer [union]]))

(def puzzle-input (get-puzzle-input 2))

(defn count-letters [s]
  (->> (frequencies s)
       (vals)
       (frequencies)))

;; part 1
(let [counts
      (reduce (fn [acc curr]
                (let [counts (count-letters curr)]
                  (-> acc
                      (update :two   #(if (counts 2) (inc %) %))
                      (update :three #(if (counts 3) (inc %) %)))))
              {:two 0, :three 0}
              puzzle-input)]
  (* (:two counts)
     (:three counts)))

;; part 2
(loop [[word & rest-words] puzzle-input
       seen #{}]
  (let [substrs (->> (range (count word))
                     (map #(str (subs word 0 %) (subs word (inc %))))
                     (into #{}))]
    (or (some seen substrs)
        (recur rest-words
               (union seen substrs)))))

