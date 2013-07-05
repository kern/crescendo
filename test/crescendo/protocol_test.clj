(ns crescendo.protocol-test
  (:require [crescendo.protocol :refer [protocol http-1-1 https-1-1]]
            [midje.sweet :refer :all]))

(fact "`protocol` converts an object to a protocol"
  (protocol nil) => nil
  (protocol http-1-1) => http-1-1
  (protocol {:major 1, :minor 1, :scheme "foo", :secure? true}) => {:major 1, :minor 1, :scheme "foo", :secure? true})
