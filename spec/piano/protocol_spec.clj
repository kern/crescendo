(ns piano.protocol-spec
  (:use speclj.core)
  (:require [piano.protocol :refer [http-1-1 https-1-1 major minor scheme secure?]]))

(describe "HTTP 1.1"
  (it "has a major version of 1"
    (should= 1 (major http-1-1)))
  (it "has a minor version of 1"
    (should= 1 (minor http-1-1)))
  (it "has a scheme of 'http'"
    (should= "http" (scheme http-1-1)))
  (it "is not secure"
    (should-not-be secure? http-1-1)))

(describe "HTTPS 1.1"
  (it "has a major version of 1"
    (should= 1 (major https-1-1)))
  (it "has a minor version of 1"
    (should= 1 (minor https-1-1)))
  (it "has a scheme of 'https'"
    (should= "https" (scheme https-1-1)))
  (it "is secure"
    (should-be secure? https-1-1)))
