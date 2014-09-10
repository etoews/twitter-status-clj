(ns tweet.core
  (:gen-class)
  (:use [clojure.pprint :only (pprint)])
  (:use [environ.core :only (env)])
  (:require
    [clojure.edn :as edn]
    [twitter.oauth :refer :all]
    [twitter.api.restful :refer :all]))

(defn -main
  "Small app to tweet a status with Clojure."
  [& args]
  (def twitter-creds
    (make-oauth-creds (env :twitter-app-consumer-key)
                      (env :twitter-app-consumer-secret)
                      (env :twitter-user-access-token)
                      (env :twitter-user-access-token-secret)))
  (statuses-update :oauth-creds twitter-creds
                   :params {:status "Tweeting with #clojure from twitter-api"}))
