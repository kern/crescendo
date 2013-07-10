(ns crescendo.ring-test
  (:require [crescendo.ring :refer :all]
            [crescendo.request :refer [request]]
            [crescendo.uri :refer [uri]]
            [midje.sweet :refer :all]))

(fact "ring request maps can be converted to requests"
  (ring->request {:server-port ..server-port..
                  :server-name ..server-name..
                  :remote-addr ..remote-addr..
                  :uri ..uri..
                  :scheme ..scheme..
                  :request-method ..method..
                  :ssl-client-cert ..certificate..
                  :headers ..headers..
                  :body ..body..}) => ..request..
  (provided
    (uri nil nil ..server-name.. ..server-port.. nil nil nil) => ..server..
    (uri nil nil nil ..remote-addr.. nil nil nil) => ..client..
    (request {:connection {:server ..server..
                           :client ..client..
                           :client-certificate ..certificate..}
              :method ..method..
              :url ..uri..
              :headers ..headers..
              :body ..body..}) => ..request..))

(fact "responses can be converted to ring response maps"
  (response->ring {:connection ..connection..
                   :status ..status..
                   :headers ..headers..
                   :body ..body..}) => {:status ..status..
                                        :headers ..headers..
                                        :body ..body..})
