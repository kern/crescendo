(ns crescendo.method-spec
  (:use speclj.core)
  (:require [crescendo.method :refer [method safe? idempotent?]]))

(describe "an HTTP method"
  (it "has a normalized form"
    (should= :get (method nil))
    (should= :post (method "post"))
    (should= :post (method :post))
    (should= :post (method "POST")))
  (it "can be safe"
    (should-be safe? :get)
    (should-be safe? :head)
    (should-be safe? :options)
    (should-not-be safe? :put)
    (should-not-be safe? :post)
    (should-not-be safe? :delete))
  (it "can be idempotent"
    (should-be idempotent? :get)
    (should-be idempotent? :head)
    (should-be idempotent? :options)
    (should-be idempotent? :put)
    (should-not-be idempotent? :post)
    (should-be idempotent? :delete)))
