(ns clojuremicro.core)

(defn not-expr [expr]
  "Converts a not-expression to a nor-expression."
  (let [[_ x] expr]                                         ;get the variable x and ignore not
    (list 'nor x x)))                                       ;return nor-expression created from input

(defn and-expr [expr]
  "Converts an and-expression to a nor-expression"
  (let [[_ & args]expr]                                     ;get all arguments while ignoring and
    (cons 'nor (map (fn [arg] (list 'nor arg arg)) args)))) ;uses map to convert each argument

(defn or-expr [expr]
  "Converts an or-expression to a nor-expression"
  (let [[_ & args] expr]                                    ;get all arguments and ignore or
    (list 'nor (cons 'nor args) (cons 'nor args))))         ;double negated arguments

(defn nor-convert [expr]
  "Converts any logical-expression to a nor-expression"
  cond (
        (= (first expr) 'not) (not-expr expr)
        (= (first expr) 'and) (and-expr expr)
        (= (first expr) 'or) (or-expr expr)
        :else (throw (IllegalArgumentException. "Expression not found"))))

