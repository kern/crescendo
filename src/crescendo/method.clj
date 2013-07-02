(ns crescendo.method
  (:require [clojure.string :refer [lower-case]]))

(def safe-methods #{:get :head :options})
(def idempotent-methods #{:get :head :options :put :delete})

(defn method
  "Normalizes the method."
  [o]
  (if o
    (-> o name lower-case keyword)
    :get))

(defn safe?
  "Determines if a method is safe."
  [method]
  (contains? safe-methods method))

(defn idempotent?
  "Determines if a method is idempotent."
  [method]
  (contains? idempotent-methods method))
