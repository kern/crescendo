(ns piano.response)

(defrecord Response [protocol status-code headers body])
