(ns leiningen.new.cljs-app
  (:require [leiningen.new.templates :refer [renderer sanitize ->files]]
            [leiningen.core.main :as main]))
(use 'hiccup.core)

(def render (renderer "cljs-app"))

(defn cljs-app
  "Create a new cljs html5 app"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)}]
    (main/info "creating files for project")
    (->files data
             ["src/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             [".gitignore" (render "gitignore" data)]
             ["index.html" (render "index.html" data)]
             ["project.clj" (render "project.clj" data)])
    (main/info "now `lein cljs-app; lein cljsbuild auto dev`, and open index.html")))
