(ns crescendo.response
  (:require [crescendo.protocol :refer [protocol]]
            [crescendo.headers :refer [headers]]))

(defrecord Response [protocol status-code headers body])

(defn response
  [m]
  (-> m
      (update-in [:protocol] protocol)
      (update-in [:headers] headers)
      map->Response))
