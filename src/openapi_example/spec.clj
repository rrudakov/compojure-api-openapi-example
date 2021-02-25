(ns openapi-example.spec
  (:require [clojure.spec.alpha :as s]))

(s/def ::x int?)

(s/def ::y int?)

(s/def ::result int?)

(s/def ::add-response (s/keys :req-un [::result]))

(s/def ::name string?)

(s/def ::description string?)

(s/def ::size #{"L" "M" "S"})

(s/def ::country #{"FI" "PO"})

(s/def ::city string?)

(s/def ::origin (s/keys :req-un [::country ::city]))

(s/def ::pizza (s/keys :req-un [::name ::size ::origin]
                       :opt-un [::description]))
