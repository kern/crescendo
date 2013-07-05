(ns crescendo.ring-test
  (:require [crescendo.ring :refer [scheme->protocol ring->request]]
            [crescendo.protocol :refer [http-1-1 https-1-1]]
            [crescendo.request :refer [request]]
            [midje.sweet :refer :all]))

(fact "`scheme->protocol` converts a symbol to a protocol"
  (scheme->protocol :http) => http-1-1
  (scheme->protocol :https) => https-1-1
  (scheme->protocol :foo) => (throws Exception))
