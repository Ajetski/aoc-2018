(ns core
  (:require [clj-http.client :as client]
            [clojure.string :as string]))

(def input-cache (atom {}))
(def cookie "session=PUT YOUR SESSION COOKIE HERE")

(defn slurp-input [day]
  (if (contains? @input-cache day)
    (@input-cache day)
    (-> "https://adventofcode.com/2018/day/"
        (str day "/input")
        (client/get {:throw-entire-message? true
                     :headers {"Cookie" cookie}})
        :body
        string/split-lines)))

