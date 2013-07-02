(ns crescendo.request-spec
  (:require [crescendo.request :refer [request host-uri reconstruct-url]]
            [crescendo.uri :refer [uri scheme host port path query fragment]]
            [speclj.core :refer :all]))

(describe "an HTTP request"
  (with req (request {:protocol {:scheme "http"}
                      :method :get
                      :request-target "/bar?baz#qux"
                      :headers {"Host" "google.com:80"}
                      :body ""}))
  (it "has a Host URI"
    (should= "google.com" (host (host-uri @req))))
  (describe "URL reconstruction"
    (context "when the request target has a scheme, host, and path"
      (with req-target (uri "http://foo.com/bar?baz#qux"))
      (with req (request {:request-target @req-target}))
      (it "uses the request target"
        (should= @req-target (reconstruct-url @req))))
    (context "when the request target does not have a scheme, host, and path"
      (it "uses the request's protocol's scheme"
        (should= "http" (scheme (reconstruct-url @req))))
      (it "uses the host and port of the Host header"
        (should= "google.com" (host (reconstruct-url @req)))
        (should= 80 (port (reconstruct-url @req))))
      (it "uses the path, query, and fragment of the request target"
        (should= "/bar" (path (reconstruct-url @req)))
        (should= "baz" (query (reconstruct-url @req)))
        (should= "qux" (fragment (reconstruct-url @req)))))))
