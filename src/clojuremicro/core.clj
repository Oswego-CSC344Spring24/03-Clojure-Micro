(ns clojuremicro.core)

(defn nor-convert [expr]
  (cond
    (nil? expr) nil
    (not (seq? expr)) expr
    (= (first expr) 'not) `(nor ,(nor-convert (second expr)))
    (= (first expr) 'and) `(nor ~@(map #(nor-convert %) (rest expr)))
    (= (first expr) 'or) `(nor ~(apply nor-convert (rest expr)))))



;; define the function nor-convert
;;A sample REPL interaction with your program might look like the following
;;a2=> (def e1 '(and x y true))
;;#'user/e1
;;a2=> (nor-convert e1)
;;(nor (nor x) (nor y) (nor true))
