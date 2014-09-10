(defproject tweet "0.1.0-SNAPSHOT"
  :description "Small app to tweet a status with Clojure"
  :url "https://github.com/everett-toews/tweet-status-clj"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.slf4j/slf4j-log4j12 "1.6.4"]
                 [log4j "1.2.13"]
                 [environ "1.0.0"]
                 [twitter-api "0.7.6"]]
  :main ^:skip-aot tweet.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
