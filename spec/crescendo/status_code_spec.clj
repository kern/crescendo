(ns crescendo.status-code-spec
  (:use speclj.core)
  (:require [crescendo.status-code :refer [informational? successful? redirection? client-error? server-error? error?]]))

(describe "a status code"
  (it "can be informational"
    (should-be informational? 100)
    (should-be informational? 199)
    (should-not-be informational? 200))
  (it "can be successful"
    (should-be successful? 200)
    (should-be successful? 299)
    (should-not-be successful? 199)
    (should-not-be successful? 300))
  (it "can be a redirection"
    (should-be redirection? 300)
    (should-be redirection? 399)
    (should-not-be redirection? 299)
    (should-not-be redirection? 400))
  (it "can be a client error"
    (should-be client-error? 400)
    (should-be client-error? 499)
    (should-not-be client-error? 399)
    (should-not-be client-error? 500))
  (it "can be a server error"
    (should-be server-error? 500)
    (should-be server-error? 599)
    (should-not-be server-error? 499))
  (it "can be an error"
    (should-be error? 400)
    (should-be error? 499)
    (should-be error? 500)
    (should-be error? 599)
    (should-not-be error? 399)))
