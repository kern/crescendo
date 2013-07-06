(ns crescendo.method-test
  (:require [crescendo.method :refer :all]
            [midje.sweet :refer :all]))

(fact "`method` converts and object to a method"
  (method :post) => :post
  (method :POST) => :post
  (method "post") => :post
  (method "POST") => :post)

(fact "GET, HEAD, and OPTIONS are safe"
  :get => safe?
  :head => safe?
  :options => safe?
  :put =not=> safe?
  :post =not=> safe?
  :delete =not=> safe?)

(fact "GET, HEAD, OPTIONS, PUT, and DELETE are idempotent"
  :get => idempotent?
  :head => idempotent?
  :options => idempotent?
  :put => idempotent?
  :post =not=> idempotent?
  :delete =not=> idempotent?)
