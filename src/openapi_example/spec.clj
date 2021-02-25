(ns openapi-example.spec
  (:require [clojure.spec.alpha :as s]
            [spec-tools.core :as st]))

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

;; Upload specs
(s/def ::filename string?)

(s/def ::content-type string?)

(s/def ::size pos-int?)

(s/def ::tempfile (partial instance? java.io.File))

(s/def ::file
  (st/spec
   {:spec    (s/keys :req-un [::filename ::content-type ::size] :opt-un [::tempfile])
    :openapi {:type   "object"
              :properties {:file {:type "string" :format "binary"}}}}))

(s/def ::file-response
  (s/keys :req-un [::filename ::content-type ::size]))
