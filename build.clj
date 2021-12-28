(ns build
  (:require [clojure.tools.build.api :as b]))

(def lib 'com.scarytom.tbs/tbs)
(def version (format "1.2.%s" (b/git-count-revs nil)))
(def class-dir "classes")
(def basis (b/create-basis {:project "deps.edn"}))
(def jar-file (format "target/%s-%s.jar" (name lib) version))

(defn clean [_]
      (b/delete {:path "target"})
      (b/delete {:path "classes"}))

(defn compile [_]
      (b/javac {:src-dirs ["src/main/java"]
                :class-dir class-dir
                :basis basis
                :javac-opts ["-source" "11" "-target" "11"]})

      (b/compile-clj {:src-dirs ["src/main/clojure"]
                      :class-dir "target/clj-classes"
                      :basis basis}))

(defn jar [_]
      (b/write-pom {:class-dir class-dir
                    :lib lib
                    :version version
                    :basis basis
                    :src-dirs ["src/main/clojure"]})
      (b/copy-dir {:src-dirs ["src/main/clojure" "src/main/resources"]
                   :target-dir class-dir})
      (b/jar {:class-dir class-dir
              :jar-file jar-file}))

