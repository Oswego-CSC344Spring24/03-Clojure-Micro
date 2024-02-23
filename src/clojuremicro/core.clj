(ns user)
; Define the nor-convert function
(defn nor-convert [expr]
  "Converts an expression to a NOR-based expression."
  (let [op (first expr)
        args (rest expr)]
    (cond
      (= op 'not) ['nor (first args)]  ; Convert NOT directly to NOR
      (= op 'or)  (cons 'nor args)     ; Convert OR to NOR by just changing the operator
      (= op 'and) ; Convert AND to a sequence of NORs
      (cons 'nor (map #(list 'nor %) args))
      :else expr))) ; Return the expression unchanged if it does not start with not, and, or or

