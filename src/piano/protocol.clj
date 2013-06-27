(ns piano.protocol)

(defprotocol Protocol
  (major [protocol])
  (minor [protocol])
  (scheme [protocol])
  (secure? [protocol]))

(def http-1-1 (reify Protocol
                (major [protocol] 1)
                (minor [protocol] 1)
                (scheme [protocol] "http")
                (secure? [protocol] false)))

(def https-1-1 (reify Protocol
                 (major [protocol] 1)
                 (minor [protocol] 1)
                 (scheme [protocol] "https")
                 (secure? [protocol] true)))
