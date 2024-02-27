(ns clojuremicro.core)
(defn nor-convert [expression]
  (cond
    (= 'not (first expression))
    (apply list 'nor (rest expression))

    (= 'and (first expression))
    (apply list 'nor (map #(list 'nor %) (rest expression)))

    (= 'or (first expression))
    (list 'nor (apply list 'nor (rest expression)))

    :else expression)
  )



;; define the function nor-convert
;;A sample REPL interaction with your program might look like the following
;;a2=> (def e1 '(and x y true))
;;#'user/e1
;;a2=> (nor-convert e1)
;;(nor (nor x) (nor y) (nor true))
