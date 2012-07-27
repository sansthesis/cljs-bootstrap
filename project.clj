(defproject cljsbootstrap "1.0.0-SNAPSHOT"
  :description "Getting Started with ClojureScript."
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1450"]
;                 [ring "1.1.1"]
;                 [compojure "1.1.1"]
;                 [enlive "1.0.1"]
;                 [org.mozilla/rhino "1.7R3"]
;                 [com.google.javascript/closure-compiler "r2079"]
;                 [org.clojure/google-closure-library "0.0-1376"]
;                 [domina "1.0.0-beta4"]
                 ]
  :plugins [[lein-pprint "1.1.1"]]
  :repl-options {:init-ns bootstrap}
  :omit-default-repositories true
  :source-paths ["src/main/clj" "src/main/cljs"]
  :target-path "target/")
