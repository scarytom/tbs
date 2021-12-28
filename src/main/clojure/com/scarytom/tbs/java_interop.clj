(ns com.scarytom.tbs.java-interop
  (require [com.scarytom.tbs.beat-box :as bb])
  (:import [com.scarytom.tbs BeatBox]))

(gen-class
  :name com.scarytom.tbs.JavaInterop
  :prefix "java-"
  :methods [#^{:static true} [makeBeatbox [] BeatBox]])

(defrecord JavaBeatBox []
  BeatBox
  (kick [_this duration]
    (bb/kick duration)))

(defn java-makeBeatbox
  (->JavaBeatBox))