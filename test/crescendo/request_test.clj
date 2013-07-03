(ns crescendo.request-test
  (:require [crescendo.request :refer [request host-uri reconstruct-url]]
            [crescendo.uri :refer [uri scheme host port path query fragment]]
            [expectations :refer :all]))

(let [request (request {:headers {:host "google.com:80"}})
      host-uri (host-uri request)]
  (expect "google.com" (host host-uri))
  (expect 80 (port host-uri)))

(let [request (request {:request-target "http://foo.com:80/bar?baz#qux"})
      url (reconstruct-url request)]
  (expect "http" (scheme url))
  (expect "foo.com" (host url))
  (expect 80 (port url))
  (expect "/bar" (path url))
  (expect "baz" (query url))
  (expect "qux" (fragment url)))

(let [request (request {:protocol {:scheme "http"}
                        :request-target "/bar?baz#qux"
                        :headers {:host "foo.com:80"}})
      url (reconstruct-url request)]
  (expect "http" (scheme url))
  (expect "foo.com" (host url))
  (expect 80 (port url))
  (expect "/bar" (path url))
  (expect "baz" (query url))
  (expect "qux" (fragment url)))
