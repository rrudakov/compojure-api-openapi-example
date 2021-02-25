(ns openapi-example.handler
  (:require [compojure.api.sweet :refer [api context GET POST]]
            openapi-example.coercion
            [openapi-example.openapi :refer [openapi-routes]]
            [openapi-example.spec :as spec]
            [ring.util.http-response :refer [ok]]))

(def app
  (api
   (openapi-routes
    {:data
     {:info
      {:title "Openapi-example"
       :description "Compojure Api example"}
      :tags [{:name "api", :description "some apis"}]}})

   (context "/api" []
     :coercion :openapi
     :tags ["api"]

     (GET "/plus" []
       :query-params [x :- ::spec/x, y :- ::spec/y]
       :summary "adds two numbers together"
       :responses {200 {:description "Successful!"
                        :schema ::spec/add-response}}
       (ok {:result (+ x y)}))

     (POST "/echo" []
       :body [pizza ::spec/pizza]
       :summary "echoes a Pizza"
       :responses {200 {:description "Successful!"
                        :schema ::spec/pizza}}
       (ok pizza)))))
