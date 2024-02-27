(ns user)

(defn not-to-nor [expr]
  (if (= (first expr) 'not)
    [list 'nor (second expr)]
    (throw (IllegalArgumentException. "Expected a not expression"))))

(defn or-to-nor [expr]
  (if (= (first expr) 'or)
    (cons 'nor (cons (rest expr) nil))
    (throw (IllegalArgumentException. "Expected an or expression"))))

(defn and-to-nor [expr]
  (if (= (first expr) 'and)
    (cons 'nor (map #(list 'nor %) (rest expr)))
    (throw (IllegalArgumentException. "Expected an and expression"))))

(defn convert-expr [expr]
  (cond
    (= (first expr) 'not) (not-to-nor expr)
    (= (first expr) 'or)  (or-to-nor expr)
    (= (first expr) 'and) (and-to-nor expr)
    else (throw (IllegalArgumentException. "Unknown expression type"))))
