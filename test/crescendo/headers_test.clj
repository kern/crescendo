(ns crescendo.headers-test
  (:require [crescendo.headers :refer :all]
            [midje.sweet :refer :all]))

(fact "`headers` converts an object to a headers map"
  (let [headers (headers {:host "google.com", :content-type "application/json"})]
    (:host headers) => "google.com"
    (:content-type headers) => "application/json")

  (let [headers (headers {:Host "google.com", :Content-Type "application/json"})]
    (:host headers) => "google.com"
    (:content-type headers) => "application/json")

  (let [headers (headers {"Host" "google.com", "Content-Type" "application/json"})]
    (:host headers) => "google.com"
    (:content-type headers) => "application/json"))
