(ns tweet.core
  (:gen-class)
  (:use [clojure.pprint :only (pprint)])
  (:require
    [clojure.edn :as edn]
    [twitter.oauth :refer :all]
    [twitter.api.restful :refer :all]))

(defn load-twitter-config
  "Load and return your Twitter configuration.
   Copy twitter.edn.template to twitter.edn and edit."
  ([] (load-twitter-config "resources/twitter.edn"))
  ([filename]
  (try
    (edn/read-string (slurp filename))
    (catch java.io.FileNotFoundException e
      (throw (java.io.FileNotFoundException.
              (str (.getMessage e) " Copy twitter.edn.template to twitter.edn and edit.")))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def twitter-config (load-twitter-config))
  (def twitter-creds
    (make-oauth-creds (:app-consumer-key twitter-config)
                      (:app-consumer-secret twitter-config)
                      (:user-access-token twitter-config)
                      (:user-access-token-secret twitter-config)))
  (statuses-update :oauth-creds twitter-creds
                   :params {:status "Tweeting with #clojure from twitter-api"}))
