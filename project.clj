(defproject openapi-example "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [metosin/compojure-api "2.0.0-alpha31"]
                 ;; Support for OpenAPI 3.0
                 [metosin/spec-tools "0.10.5"]
                 [metosin/ring-swagger-ui "3.36.0"]]
  :ring {:handler openapi-example.handler/app}
  :uberjar-name "server.jar"
  :profiles {:dev {:dependencies [[javax.servlet/javax.servlet-api "3.1.0"]]
                   :plugins [[lein-ring "0.12.5"]
                             [lein-cljfmt "0.7.0"]]}})
