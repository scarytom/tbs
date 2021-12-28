(ns com.scarytom.tbs.beat-box-test
  (:require [clojure.test :refer :all]
            [com.scarytom.tbs.beat-box :as bb]))

(deftest kick-it
  (is (= (bb/kick 2) "BOOMBOOM")))