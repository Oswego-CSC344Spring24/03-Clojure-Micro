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
