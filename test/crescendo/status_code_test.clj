(ns crescendo.status-code-test
  (:require [crescendo.status-code :refer [informational? successful? redirection? client-error? server-error? error?]]
            [expectations :refer :all]))

(expect informational? 100)
(expect informational? 199)
(expect (complement informational?) 200)

(expect successful? 200)
(expect successful? 299)
(expect (complement successful?) 199)
(expect (complement successful?) 300)

(expect redirection? 300)
(expect redirection? 399)
(expect (complement redirection?) 299)
(expect (complement redirection?) 400)

(expect client-error? 400)
(expect client-error? 499)
(expect (complement client-error?) 399)
(expect (complement client-error?) 500)

(expect server-error? 500)
(expect server-error? 599)
(expect (complement server-error?) 499)

(expect error? 400)
(expect error? 499)
(expect error? 500)
(expect error? 599)
(expect (complement error?) 399)
