(ns crescendo.request
  (:require [crescendo.protocol :refer [protocol]]
            [crescendo.uri :refer [uri scheme host port path query fragment]]
            [crescendo.method :refer [method]]
            [crescendo.headers :refer [headers]]))

(defrecord Request [protocol method request-target headers body])

(defn request
  [m]
  (-> m
      (update-in [:protocol] protocol)
      (update-in [:method] method)
      (update-in [:request-target] uri)
      (update-in [:headers] headers)
      map->Request))

(defn host-uri
  "Creates a URI out of a request's Host header."
  [request]
  (uri (str "//" (get-in request [:headers "Host"]))))

(defn reconstruct-url
  "Reconstructs a request's URL from its request-target, Host header, and
  scheme."
  [{:keys [protocol request-target], :as request}]
  (if (scheme request-target)
    request-target
    (let [host-uri (host-uri request)]
      (uri (:scheme protocol)
           nil
           (host host-uri)
           (port host-uri)
           (path request-target)
           (query request-target)
           (fragment request-target)))))
