(ns crescendo.ring
  (:require [crescendo.protocol :refer [http-1-1 https-1-1]]
            [crescendo.request :refer [request]]))

(defn scheme->protocol
  [scheme]
  (condp = scheme
    :http http-1-1
    :https https-1-1
    (throw (ex-info (str "Unknown scheme '" scheme "'.") {::scheme scheme}))))

(defn ring->request
  [{:keys [scheme request-method uri headers body]}]
  (request {:protocol (scheme->protocol scheme)
            :method request-method
            :request-target uri
            :headers headers
            :body body}))
