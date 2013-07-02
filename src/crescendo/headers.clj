(ns crescendo.headers
  (:require [clojure.string :refer [lower-case]]))

(defn- normalize-key
  [k]
  (lower-case (name k)))

(defn- normalize-keys
  [m]
  (reduce-kv #(assoc %1 (normalize-key %2) %3) {} m))

(deftype Headers [m]
  clojure.lang.IPersistentMap
  (assoc [_ k v] (Headers. (.assoc m (normalize-key k) v)))
  (assocEx [_ k v] (Headers. (.assocEx m (normalize-key k) v)))
  (without [_ k] (Headers. (.without m (normalize-key k))))

  java.lang.Iterable
  (iterator [this] (.iterator m))

  clojure.lang.Associative
  (containsKey [_ k] (.containsKey m (normalize-key k)))
  (entryAt [_ k] (.entryAt m (normalize-key k)))

  clojure.lang.IPersistentCollection
  (count [_] (.count m))
  (cons [_ o] (Headers. (.cons m (normalize-key o))))
  (empty [_] (.empty m))
  (equiv [_ o]
    (and (isa? (class o) Headers)
         (.equiv m (.m o))))

  clojure.lang.Seqable
  (seq [_] (.seq m))

  clojure.lang.ILookup
  (valAt [_ k] (.valAt m (normalize-key k)))
  (valAt [_ k not-found] (.valAt m (normalize-key k) not-found)))

(defn headers
  [m]
  (Headers. (normalize-keys m)))
