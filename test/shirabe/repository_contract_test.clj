(ns shirabe.repository-contract-test
  (:require [clojure.edn :as edn] [clojure.java.io :as io]
            [clojure.test :refer [deftest is]]))
(deftest repository-boundary
  (let [c (edn/read-string (slurp "repository-contracts.edn"))]
    (is (= :edn (get-in c [:canonical :format])))
    (doseq [p ["manifest.edn" "schema.edn" "lex/researchSession.edn"
               "wire/manifest.jsonld" "wire/lexicons/researchSession.json"]]
      (is (.isFile (io/file p)) p))
    (is (not (.exists (io/file "manifest.jsonld"))))))
