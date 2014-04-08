(ns leiningen.cljs-app
   (:require [leiningen.core.eval :refer [eval-in-project]]))


(defn cljs-app
  [project & args]
  (println "HERE")
  (comment eval-in-project ...)
  )
