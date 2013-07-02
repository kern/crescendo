(ns crescendo.uri
  (:import [java.net URI]))

(defn uri
  ([o] (if (string? o) (URI. o) o))
  ([s1 s2 s3] (URI. s1 s2 s3))
  ([s1 s2 s3 s4] (URI. s1 s2 s3 s4))
  ([s1 s2 s3 s4 s5] (URI. s1 s2 s3 s4 s5))
  ([s1 s2 s3 i s4 s5 s6] (URI. s1 s2 s3 (or i -1) s4 s5 s6)))

(defn scheme
  "Returns the URI's scheme."
  [uri]
  (.getScheme uri))

(defn scheme-specific-part
  "Returns the URI's scheme specific part."
  [uri]
  (.getSchemeSpecificPart uri))

(defn authority
  "Returns the URI's authority."
  [uri]
  (.getAuthority uri))

(defn user-info
  "Returns the URI's user info."
  [uri]
  (.getUserInfo uri))

(defn host
  "Returns the URI's host."
  [uri]
  (.getHost uri))

(defn port
  "Returns the URI's port."
  [uri]
  (let [i (.getPort uri)]
    (when-not (= -1 i) i)))

(defn path
  "Returns the URI's path."
  [uri]
  (.getPath uri))

(defn query
  "Returns the URI's query."
  [uri]
  (.getQuery uri))

(defn fragment
  "Returns the URI's fragment."
  [uri]
  (.getFragment uri))
