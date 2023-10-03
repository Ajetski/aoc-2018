(ns day2
  (:require [core :refer [get-puzzle-input]]))

(defn count-letters [s]
  (->> (frequencies s)
       (vals)
       (frequencies)))

;; part 1
(let [words (get-puzzle-input 2)
      counts (reduce
              (fn [{two :two, three :three}
                   curr]
                (let [counts (count-letters curr)]
                  {:two (if (contains? counts 2)
                          (inc two)
                          two)
                   :three (if (contains? counts 3)
                            (inc three)
                            three)}))
              {:two 0, :three 0}
              words)]
  (* (:two counts) (:three counts)))

;; part 2
()
