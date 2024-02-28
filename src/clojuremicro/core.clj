(ns clojuremicro.core)

(defn convert-not [expr]
  (if (= (first expr) 'not)
    (list 'nor (second expr))
    expr))

(defn convert-and [expr]
  (if (= (first expr) 'and)
    (cons 'nor (map (fn [e] (list 'nor e)) (rest expr)))
    expr))

(defn convert-or [expr]
  (if (= (first expr) 'or)
    (list 'nor (cons 'nor (rest expr)))
    expr))



(defn nor-convert [expression]
  (cond
    (and (list? expression) (= (first expression) 'not))
    (convert-not  expression)

    (and (list? expression) (= (first expression) 'and))
    (convert-and  expression)

    (and (list? expression) (= (first expression) 'or))
    (convert-or expression)

    :else (convert-not  expression)))




;; define the function nor-convert
;;A sample REPL interaction with your program might look like the following
;;a2=> (def e1 '(and x y true))
;;#'user/e1
;;a2=> (nor-convert e1)
;;(nor (nor x) (nor y) (nor true))
