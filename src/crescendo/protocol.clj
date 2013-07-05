(ns crescendo.protocol)

(defrecord Protocol [major minor scheme secure?])

(defn protocol
  [o]
  (cond
    (nil? o) nil
    (map? o) (map->Protocol o)
    :else o))

(def http-1-1 (->Protocol 1 1 "http" false))
(def https-1-1 (->Protocol 1 1 "https" true))
