(ns crescendo.ring
  (:require [crescendo.request :refer [request]]
            [crescendo.uri :as uri]))

(defn ring->request
  [{:keys [server-port server-name remote-addr uri scheme request-method
           ssl-client-cert headers body]}]
  (let [server (uri/uri nil nil server-name server-port nil nil nil)
        client (uri/uri nil nil nil remote-addr nil nil nil)]
    (request {:connection {:server server
                           :client client
                           :client-certificate ssl-client-cert}
              :method request-method
              :url uri
              :headers headers
              :body body})))

(defn response->ring
  [response]
  (dissoc response :connection))
