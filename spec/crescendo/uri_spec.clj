(ns crescendo.uri-spec
  (:use speclj.core)
  (:require [crescendo.uri :refer [uri]]))

(describe "a URI"
  (it "has a normalized form"
    (should= (uri "google.com") (uri "google.com"))
    (should= (uri "http://facebook.com") (uri (java.net.URI/create "http://facebook.com")))))
