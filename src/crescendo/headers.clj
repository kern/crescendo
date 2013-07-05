(ns crescendo.headers
  (:require [clojure.string :refer [lower-case]]))

(defn- normalize-key
  [k]
  (keyword (lower-case (name k))))

(defn headers
  [m]
  (reduce-kv #(assoc %1 (normalize-key %2) %3) {} m))
