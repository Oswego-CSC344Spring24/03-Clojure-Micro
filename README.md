# Clojure Microproject

Write one or more Clojure function(s) to symbolically convert logical expressions using the and, or, and not connectives to expressions using only nor. To do this, use a Lisp-style prefix notation to represent the logical expressions as unevaluated lists, allowing for a single argument for the not connective, and two or more arguments for the and and or connectives. In this microproject you do not need to worry about recursive cases (i.e., nested logical expressions), though you will need to for the main project. To perform the symbolic conversion you must have your program deconstruct the input lists and build new lists to output. A sample of the conversions for you to generalize from are provided below.

# Example
  | logical expression|		| nor expression|
 |-------------|--------------|---|
|(not x)    |   -> |(nor x)|
|(and x y)   |  -> |(nor (nor x) (nor y))|
|(and x y z) |  ->| (nor (nor x) (nor y) (nor z))|
|(and w x y z) |-> |(nor (nor w) (nor x) (nor y) (nor z))|
|(or x y)   |   -> |(nor (nor x y))|
|(or x y z)  |  ->| (nor (nor x y z))|
|(or w x y z) | -> |(nor (nor w x y z))|

# Implementation suggestions
In order to ease your implementation, I recommend, but do not require, following the below checklist to guide your work. Remember to follow good practices and thoroughly test each function as your implementation progresses.

- Implement a function taking a list representing a not-expression as an argument, and returning a list representing a nor-expression created from the input.
- Implement a function taking a list representing an or-expression as an argument, and returning a list representing a nor-expression created from the input.
- Implement a function taking a list representing an and-expression as an argument, and returning a list representing a nor-expression created from the input. Make use of a higher-order function to help.
- Implement a function taking a list representing an expression as an argument which returns the result of the appropriate more specific function called with the input expression.

# A Sample REPL 
A sample REPL interaction with your program might look like the following:


`a2=> (def e1 '(and x y true))`<br />
`#'user/e1`<br />
`a2=> (nor-convert e1)`<br />
`(nor (nor x) (nor y) (nor true))`<br />


