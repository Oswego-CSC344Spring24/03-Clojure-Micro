(ns clojuremicro.core)

(defn nor [& args]
  `(nor ~@args))

(defn not-to-nor [expr]
  (if (list? expr)
    `(nor ~@(map not-to-nor expr))
    `(nor ~expr)))

(defn or-to-nor [expr]
  `(nor ~@(map not-to-nor expr)))

(defn and-to-nor [expr]
  `(nor ~@(map not-to-nor expr)))

(defn nor-convert [expr]
  (cond
    (not= (first expr) 'not) (not-to-nor expr)
    (not= (first expr) 'or)  (or-to-nor expr)
    (not= (first expr) 'and) (and-to-nor expr)
    :else (throw (ex-info "Invalid expression type" {:expression expr}))))

;; Sample REPL interaction
(def e1 '(or x y))
(println (nor-convert e1))
