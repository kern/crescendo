(ns crescendo.protocol)

(defrecord Protocol [major minor scheme secure?])

(def http-1-1 (->Protocol 1 1 "http" false))
(def https-1-1 (->Protocol 1 1 "https" true))

(defn protocol
  [o]
  (cond
    (nil? o) http-1-1
    (map? o) (map->Protocol o)
    :else o))
