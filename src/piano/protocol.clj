(ns piano.protocol)

(defprotocol Protocol
  (major [protocol])
  (minor [protocol])
  (secure? [protocol]))

(def http-1-1 (reify Protocol
                (major [protocol] 1)
                (minor [protocol] 1)
                (secure? [protocol] false)))
