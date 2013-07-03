(defproject crescendo "0.1.0-SNAPSHOT"
  :description "An HTTP abstraction."
  :url "https://github.com/CapnKernul/crescendo"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins [[lein-expectations "0.0.8"]
            [lein-autoexpect "0.2.5"]]
  :profiles {:dev {:dependencies [[expectations "1.4.49"]]}})
