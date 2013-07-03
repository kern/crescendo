(ns crescendo.uri-test
  (:require [crescendo.uri :refer [uri scheme scheme-specific-part authority user-info host port path query fragment]]
            [expectations :refer :all]))

(let [uri (uri "http://user@foo.com:80/bar?baz#qux")]
  (expect "http" (scheme uri))
  (expect "//user@foo.com:80/bar?baz" (scheme-specific-part uri))
  (expect "user@foo.com:80" (authority uri))
  (expect "user" (user-info uri))
  (expect "foo.com" (host uri))
  (expect 80 (port uri))
  (expect "/bar" (path uri))
  (expect "baz" (query uri))
  (expect "qux" (fragment uri)))

(expect (uri "http://facebook.com")
        (uri (java.net.URI/create "http://facebook.com")))
