(ns piano.request)

(defrecord Request [protocol method request-target headers body])
