(ns crescendo.uri-spec
  (:require [crescendo.uri :refer [uri]]
            [speclj.core :refer :all]))

(describe "a URI"
  (it "has a normalized form"
    (should= (uri "google.com") (uri "google.com"))
    (should= (uri "http://facebook.com") (uri (java.net.URI/create "http://facebook.com")))))
