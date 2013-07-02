(ns crescendo.protocol-spec
  (:use speclj.core)
  (:require [crescendo.protocol :refer [protocol http-1-1 https-1-1]]))

(describe "a protocol"
  (with proto (protocol {:major -1
                         :minor -2
                         :scheme "foo"
                         :secure? true}))
  (it "has a normalized form"
    (should= http-1-1 (protocol nil))
    (should= https-1-1 (protocol https-1-1))
    (should= -1 (:major @proto))
    (should= -2 (:minor @proto))
    (should= "foo" (:scheme @proto))
    (should-be :secure? @proto)))

(describe "HTTP 1.1"
  (it "has a major version of 1"
    (should= 1 (:major http-1-1)))
  (it "has a minor version of 1"
    (should= 1 (:minor http-1-1)))
  (it "has a scheme of 'http'"
    (should= "http" (:scheme http-1-1)))
  (it "is not secure"
    (should-not-be :secure? http-1-1)))

(describe "HTTPS 1.1"
  (it "has a major version of 1"
    (should= 1 (:major https-1-1)))
  (it "has a minor version of 1"
    (should= 1 (:minor https-1-1)))
  (it "has a scheme of 'https'"
    (should= "https" (:scheme https-1-1)))
  (it "is secure"
    (should-be :secure? https-1-1)))
