(ns bootstrap
  (:require [clojure.java.io :as io]
            [routes :as routes])
  (:use [cljs.closure :only [build]]))

(def default-opts {:optimizations :whitespace
                   :output-dir "target/generated/js/out"
                   :output-to "target/classes/js/core.js"
                   :pretty-print true})

(def dirs ["target/generated/js/out" "target/classes/js"])

(defn build-cljs
  [& args]
  (let [opts (merge default-opts (apply hash-map args))]
    (build "src/main/cljs" opts)
    opts))
  
(defn mkdirs
  []
  (doseq [dir dirs] (.mkdirs (io/file dir))))

(defn dev-server
  []
  (routes/dev-server))

(mkdirs)

(println)
(println "Type (dev-server) to launch only the development server.")
(println "Type (build-cljs) to precompile clojurescript.")
(println)
