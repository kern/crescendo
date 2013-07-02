(ns crescendo.headers-spec
  (:require [crescendo.headers :refer [headers]]
            [speclj.core :refer :all]))

(describe "a headers map"
  (with hs (headers {"Host" "google.com",
                     "Content-type" "application/json"}))
  (it "functions like a normal hash map"
    (should= "google.com" (get @hs "Host"))
    (should= "application/json" (get @hs "Content-type"))
    (should= "facebook.com" (get (assoc @hs "Host" "facebook.com") "Host")))
  (it "has case-insensitive access"
    (should= "google.com" (get @hs "host"))
    (should= "application/json" (get @hs "cONtEnT-tYPe"))
    (should= "facebook.com" (get (assoc @hs "hoSt" "facebook.com") "hOST")))
  (it "can use keywords and strings for keys interchangeably"
    (should= "google.com" (:host @hs))
    (should= "application/json" (:conTent-Type @hs))
    (should= "facebook.com" (:HOsT (assoc @hs :hoSt "facebook.com")))))
