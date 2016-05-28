(defproject crucible "0.4.1-SNAPSHOT"
  :description "AWS Cloudformation templates in Clojure"
  :url "http://github.com/brabster/crucible"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[camel-snake-kebab "0.4.0"]
                [org.clojure/clojure "1.8.0"]]
  :plugins [[lein-ancient "0.6.10"]
            [lein-kibit "0.1.2" :exclusions [clojure.core]]
            [jonase/eastwood "0.2.3"]
            [lein-cloverage "1.0.6"]]
  :repositories [["snapshots" {:url "https://clojars.org/repo"
                              :username :env/clojars_username
                              :password :env/clojars_password}]
                ["releases" {:url "https://clojars.org/repo"
                            :username :env/clojars_username
                            :password :env/clojars_password
                            :sign-releases false}]]
  :main ^:skip-aot crucible.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
