(ns crescendo.response
  (:require [crescendo.headers :refer [headers]]))

(defrecord Response [connection status headers body])

(defn response
  [m]
  (-> m
      (update-in [:headers] headers)
      map->Response))
