(ns clojureMicro.core)
;;comment

(defn norConvert [expression]
  (cond
    (= 'not (first expression))
    (apply list 'nor (rest expression))

    (= 'and (first expression))
    (apply list 'nor (map #(list 'nor %) (rest expression)))

    (= 'or (first expression))
    (list 'nor (apply list 'nor (rest expression)))

    :else expression)
  )

(println (norConvert '(not x)))
(println (norConvert '(and x y)))
(println (norConvert '(and x y z)))
(println (norConvert '(and w x y z)))
(println (norConvert '(or x y)))
(println (norConvert '(or x y z)))
(println (norConvert '(or w x y z)))




