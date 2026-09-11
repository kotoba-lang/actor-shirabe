(require '[clojure.test :as t])
(def suites '[shirabe.tests.test-analyze shirabe.tests.test-kotoba
              shirabe.tests.test-retrieve shirabe.tests.test-session
              shirabe.tests.test-synthesize shirabe.murakumo-test
              shirabe.repository-contract-test])
(apply require suites)
(let [{:keys [fail error] :as r} (apply t/run-tests suites)]
  (println (select-keys r [:test :pass :fail :error]))
  (when (pos? (+ fail error)) (System/exit 1)))
