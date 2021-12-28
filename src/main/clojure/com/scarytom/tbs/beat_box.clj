(ns com.scarytom.tbs.beat-box
  (:require [clojure.string :as string]))

(defn kick [duration]
  (string/join (repeat duration "BOOM")))

(defn hi-hat []
  "PTSH")