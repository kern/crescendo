(ns crescendo.headers-test
  (:require [crescendo.headers :refer [headers]]
            [expectations :refer :all]))


(let [headers (headers {:host "google.com"
                        :content-type "application/json"})]
  (expect "google.com" (:host headers))
  (expect "google.com" (get headers "HoSt"))

  (expect "facebook.com" (:host (assoc headers :host "facebook.com")))
  (expect "facebook.com" (:host (assoc headers "HoSt" "facebook.com")))

  (expect "application/json" (:content-type headers))
  (expect "application/json" (:conTent-TyPe headers))
  (expect "application/json" (get headers "cONtEnT-tYPe")))
