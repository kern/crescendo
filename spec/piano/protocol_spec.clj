(ns piano.protocol-spec
  (:use speclj.core)
  (:require [piano.protocol :refer [http-1-1 major minor secure?]]))

(describe "HTTP 1.1"
  (it "has a major version of 1"
    (should= 1 (major http-1-1)))
  (it "has a minor version of 1"
    (should= 1 (minor http-1-1)))
  (it "is not secure"
    (should-not-be secure? http-1-1)))
