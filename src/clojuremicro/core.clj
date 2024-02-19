(ns clojuremicro.core)

(defn convert-not [expr]
  (if (= (first expr) 'not)
    (list 'nor (second expr))
    expr))


(defn convert-or [expr]
  (if (= (first expr) 'or)
    (cons 'nor (list (rest expr)))
    expr))

(defn convert-and [expr]
  (if (= (first expr) 'and)
    (cons 'nor (map (fn [e] (list 'nor e)) (rest expr)))
    expr))

(defn nor-convert [expr]
  (cond
    (= (first expr) 'not) (convert-not expr)
    (= (first expr) 'or)  (convert-or expr)
    (= (first expr) 'and) (convert-and expr)
    :else expr)) 



;; define the function nor-convert
;;A sample REPL interaction with your program might look like the following
;;a2=> (def e1 '(and x y true))
;;#'user/e1
;;a2=> (nor-convert e1)
;;(nor (nor x) (nor y) (nor true))
