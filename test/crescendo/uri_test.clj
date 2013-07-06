(ns crescendo.uri-test
  (:require [crescendo.uri :refer :all]
            [midje.sweet :refer :all]))

(fact "`uri` converts an object to a URI"
  (uri "http://foo.com") => (java.net.URI/create "http://foo.com")
  (uri (java.net.URI/create "http://foo.com")) => (uri "http://foo.com"))

(fact "URIs have multiple parts"
  (let [uri (uri "http://user@foo.com:80/bar?baz#qux")]
    (scheme uri) => "http"
    (scheme-specific-part uri) => "//user@foo.com:80/bar?baz"
    (user-info uri) => "user"
    (host uri) => "foo.com"
    (port uri) => 80
    (path uri) => "/bar"
    (query uri) => "baz"
    (fragment uri) => "qux"))
