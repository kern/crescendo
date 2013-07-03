(ns crescendo.protocol-test
  (:require [crescendo.protocol :refer [protocol http-1-1 https-1-1]]
            [expectations :refer :all]))

(expect http-1-1 (protocol nil))
(expect https-1-1 (protocol https-1-1))
(expect -1 (:major (protocol {:major -1})))
(expect -2 (:minor (protocol {:minor -2})))
(expect "foo" (:scheme (protocol {:scheme "foo"})))
(expect true (:secure? (protocol {:secure? true})))

(expect 1 (:major http-1-1))
(expect 1 (:minor http-1-1))
(expect "http" (:scheme http-1-1))
(expect false (:secure? http-1-1))

(expect 1 (:major https-1-1))
(expect 1 (:minor https-1-1))
(expect "https" (:scheme https-1-1))
(expect true (:secure? https-1-1))
