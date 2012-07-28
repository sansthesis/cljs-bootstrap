(ns routes
  (:use [compojure.core :only (defroutes GET)]
        [ring.adapter.jetty :only (run-jetty)]
        [hiccup.page :only (html5 include-js)])
  (:require [compojure.route :as route]))
  
(def config {:js-root "target/classes/js/"})

(defn template
  [& args]
  (html5 {:xml? true}
      [:head
       [:title "Compojure/Hiccup Templated Page"]
       [:meta {:charset "utf-8"}]
       (include-js "/js/core.js")]
      [:body]))

(defn output-js
  [path]
  (let [fullpath (str (:js-root config) path)]
    (slurp fullpath)))
  
(defroutes app
  (GET "/" [] (template))
  (GET "/js/:path" [path] (output-js path))
  (route/not-found nil))

(defn dev-server
  []
  (run-jetty (var app) {:join? false :port 8080}))
