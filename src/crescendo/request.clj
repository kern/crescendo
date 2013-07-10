(ns crescendo.request
  (:require [crescendo.uri :refer [uri]]
            [crescendo.method :refer [method]]
            [crescendo.headers :refer [headers]]))

(defrecord Request [connection method url headers body])

(defn request
  [m]
  (-> m
      (update-in [:method] method)
      (update-in [:url] uri)
      (update-in [:headers] headers)
      map->Request))
