(ns crescendo.status-code)

(defn informational?
  "Determines if a status code is informational."
  [status-code]
  (<= 100 status-code 199))

(defn successful?
  "Determines if a status code is successful."
  [status-code]
  (<= 200 status-code 299))

(defn redirection?
  "Determines if a status code is a redirection."
  [status-code]
  (<= 300 status-code 399))

(defn client-error?
  "Determines if a status code is informational."
  [status-code]
  (<= 400 status-code 499))

(defn server-error?
  "Determines if a status code is a server error."
  [status-code]
  (<= 500 status-code 599))

(defn error?
  "Determines if a status code is an error."
  [status-code]
  (<= 400 status-code 599))
