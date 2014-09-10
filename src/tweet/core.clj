(ns tweet.core
  (:gen-class)
  (:use [clojure.pprint :only (pprint)])
  (:use [environ.core :only (env)])
  (:require
    [clojure.string :as string]
    [clojure.tools.cli :refer [parse-opts]]
    [twitter.oauth :refer :all]
    [twitter.api.restful :refer :all]))

(defn -main
  "Small app to tweet a status with Clojure.
  Usage: twitter-status-clj STATUS
  Example: twitter-status-clj \"Tweeting with Clojure\""
  [& args]
  (def status (nth args 0))
  (def twitter-creds
    (make-oauth-creds (env :twitter-app-consumer-key)
                      (env :twitter-app-consumer-secret)
                      (env :twitter-user-access-token)
                      (env :twitter-user-access-token-secret)))
  (statuses-update :oauth-creds twitter-creds
                   :params {:status status}))
