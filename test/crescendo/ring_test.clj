(ns crescendo.ring-test
  (:require [crescendo.ring :refer [scheme->protocol ring->request response->ring]]
            [crescendo.protocol :refer [http-1-1 https-1-1]]
            [crescendo.request :refer [request]]
            [midje.sweet :refer :all]))

(fact "`scheme->protocol` converts a symbol to a protocol"
  (scheme->protocol :http) => http-1-1
  (scheme->protocol :https) => https-1-1
  (scheme->protocol :foo) => throws)

(fact "ring request maps can be converted to requests"
  (ring->request {:scheme ..scheme..
                  :request-method ..method..
                  :uri ..uri..
                  :headers ..headers..
                  :body ..body..}) => ..request..
  (provided
    (scheme->protocol ..scheme..) => ..protocol..
    (request {:protocol ..protocol..
              :method ..method..
              :request-target ..uri..
              :headers ..headers..
              :body ..body..}) => ..request..))

(fact "responses can be converted to ring response maps"
  (response->ring {:status-code ..status-code..
                   :headers ..headers..
                   :body ..body..}) => {:status ..status-code..
                                        :headers ..headers..
                                        :body ..body..})
