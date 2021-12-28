(ns com.scarytom.tbs.java-interop
  (:require [com.scarytom.tbs.beat-box :as bb]))

(gen-class
  :name com.scarytom.tbs.JavaInterop
  :prefix "java-"
  :methods [#^{:static true} [makeBeatBox [] com.scarytom.tbs.BeatBox]])

(defrecord JavaBeatBox []
  com.scarytom.tbs.BeatBox
  (kick [_this duration]
    (bb/kick duration)))

(defn java-makeBeatBox []
  (map->JavaBeatBox {}))