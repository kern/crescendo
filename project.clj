(defproject crescendo "0.1.0-SNAPSHOT"
  :description "An HTTP abstraction."
  :url "https://github.com/CapnKernul/crescendo"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins [[lein-midje "3.0.1"]]
  :profiles {:dev {:dependencies [[midje "1.6-alpha1"]]}})
