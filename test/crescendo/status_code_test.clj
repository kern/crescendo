(ns crescendo.status-code-test
  (:require [crescendo.status-code :refer [informational? successful? redirection? client-error? server-error? error?]]
            [midje.sweet :refer :all]))

(fact "informational status codes are in the 100s"
  100 => informational?
  199 => informational?
  200 =not=> informational?)

(fact "successful status codes are in the 200s"
  199 =not=> successful?
  200 => successful?
  299 => successful?
  300 =not=> successful?)

(fact "redirection status codes are in the 300s"
  299 =not=> redirection?
  300 => redirection?
  399 => redirection?
  400 =not=> redirection?)

(fact "client error status codes are in the 400s"
  399 =not=> client-error?
  400 => client-error?
  499 => client-error?
  500 =not=> client-error?)

(fact "server error status codes are in the 500s"
  499 =not=> server-error?
  500 => server-error?
  599 => server-error?)

(fact "error status codes are in the 400s and 500s"
  399 =not=> error?
  400 => error?
  499 => error?
  500 => error?
  599 => error?)
