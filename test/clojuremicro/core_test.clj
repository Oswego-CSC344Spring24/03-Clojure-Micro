(ns clojuremicro.core-test
  (:require [clojure.test :refer :all]
            [clojuremicro.core :refer :all]))

(deftest testnot
  (testing "test for not."
    (is (= (nor-convert '(not a))  '(nor a)))))

(deftest testand
  (testing "test for and."
    (is (= (nor-convert '(and x y))  '(nor (nor x) (nor y))))
    (is (= (nor-convert '(and x y z))  '(nor (nor x ) (nor y)(nor z))))
    (is (= (nor-convert '(and x y z false))  '(nor (nor x ) (nor y)(nor z)(nor false))))
    ))

(deftest testor
  (testing "test for or."
    (is (= (nor-convert '(or x y))  '(nor (nor x y))))
    (is (= (nor-convert '(or x y z))  '(nor (nor x y z))))
    (is (= (nor-convert '(or x y z true))  '(nor (nor x y z true))))

    )) 


(deftest testnor
  (testing "test for nor-convert."
    (is (= (nor-convert '(and x y true))  '(nor (nor x) (nor y) (nor true))))))
