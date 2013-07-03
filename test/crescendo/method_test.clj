(ns crescendo.method-test
  (:require [crescendo.method :refer [method safe? idempotent?]]
            [expectations :refer :all]))

(expect :get (method nil))
(expect :post (method "post"))
(expect :post (method :post))
(expect :post (method "POST"))

(expect safe? :get)
(expect safe? :head)
(expect safe? :options)
(expect (not (safe? :put)))
(expect (not (safe? :post)))
(expect (not (safe? :delete)))

(expect idempotent? :get)
(expect idempotent? :head)
(expect idempotent? :options)
(expect idempotent? :put)
(expect (not (idempotent? :post)))
(expect idempotent? :delete)