(ns crescendo.request-test
  (:require [crescendo.request :refer [request host-uri reconstruct-url]]
            [crescendo.uri :refer [uri scheme host port path query fragment]]
            [midje.sweet :refer :all]))

(fact "`host-uri` returns a URI of the Host header"
  (host-uri {:headers {:host "foo.com"}}) => ..host-uri..
  (provided (uri "//foo.com") => ..host-uri..))

(fact "requests can reconstruct their URLs"
  (reconstruct-url {:request-target ..target..}) => ..target..
  (provided (scheme ..target..) => "http")
  (reconstruct-url {:protocol {:scheme "http"}
                    :headers {:host "foo.com:80"}
                    :request-target ..target..}) => (uri "http://foo.com:80/bar?baz#qux")
  (provided
    (scheme ..target..) => nil
    (path ..target..) => "/bar"
    (query ..target..) => "baz"
    (fragment ..target..) => "qux"))
