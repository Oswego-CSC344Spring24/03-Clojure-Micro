(ns user)

(defn nor-convert [expr]
  "Converts an expression to a NOR-based expression ."
  (let [op (first expr)
        args (rest expr)]
    (cond
      (= op 'not) ['nor (first args)] 
      (= op 'or)  (cons 'nor args)    
      (= op 'and) ; 
      (cons 'nor (map #(list 'nor %) args))
      :else expr))) 
;Crazy? I was crazy once. They locked me in a room. A rubber room. A rubbeer room full of rats. And rats. rats make me crazy.
