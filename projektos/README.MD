# Program's Formatting

The program consists of a sequence of commands. Commands are written with free formatting. Comments, spaces, tabs, and line breaks serve only as delimiters and do not affect the meaning of the program. Comments are bounded by two slashes (`//`) and the end of the line. Keywords are reserved. Identifiers and keywords are case sensitive.

## Literals

There are following literals:

- `integers` (`int`) - sequence of digits.
- `floating point numbers` (`float`) - sequence of digits containing a `'.'` character.
- `booleans` (`bool`) - values: `true` and `false`.
- `strings` (`string`) - text given in quotation marks: `"text"`. Escape sequences are optional in our strings.

## Variables

Variable's identifiers are composed from letters and digits, and it must start with a letter. Each variable must be declared before it is used. Repeated declaration of a variable with the same name is an error. Variables must have one of the following types: `int`, `float`, `bool` or `string`. After the variables are declared, they have initial values: `0`, `0.0`, `""` respectively `false`.

## Statements

Following statements are defined:

- `;` - empty command.
- `type variable, variable, ... ;` - declaration of variables, all these variables have the same type `type`. It can be one of: `int`, `float`, `bool`, `String`
- `expression ;` - it evaluates given expression, the resulting value of the expression is ignored. Note, there can be some side effects like an assignment to a variable.
- `read variable, variable, ... ;` - it reads values ​​from standard input and then these values are assigned to corresponding variables. Each of these input values is on a separate line and it is verified, that have an appropriate type.
- `write expression, expression, ... ;` - it writes values of expressions to standard output. The `"\n"` character is written after the value of the last expression.
- `{ statement statement ... }` - block of statements.
- `if (condition) statement [else statement]` - conditional statement - condition is an expression with a type: `bool`. The `else` part of the statement is optional.
- `while (condition) statement` - a cycle - condition must be a `bool` expression. This cycle repeats the given statement while the condition holds (it is true).

# Expression

Lists in expressions trees are literals or variables. Types of operands must preserve the type of the operator. If necessary, `int` values are automatically cast to `float`. In other words, the type of `5 + 5.5` is `float`, and number `5` which type is `int` is automatically converted to `float`. There is no conversion from `float` to `int`!

The following table defines operators in our expressions. Operator Signature is defined using letters: `I`, `F`, `B`, `S` which corresponds to types: `int`, `float`, `bool`, `string`.

| Description                   | Operator | Operator's Signature                        |
|-------------------------------|----------|---------------------------------------------|
| unary minus                   | `-`      | `I → I` \| `F → F`                           |
| binary arithmetic operators   | `+`, `-`, `*`, `/` | `I × I → I` \| `F × F → F`                 |
| modulo                        | `%`      | `I × I → I`                                 |
| concatenation of strings      | `.`      | `S × S → S`                                 |
| relational operators          | `<`, `>` | `x × x → B`, where `x ∈ {I, F}`            |
| comparison                    | `==`, `!=` | `x × x → B`, where `x ∈ {I, F, S}`         |
| logic and, or                 | `&&`, `\|\|` | `B × B → B`                                 |
| logic not                     | `!`      | `B → B`                                     |
| assignment                    | `=`      | `x × x → x`, where `x ∈ {I, F, S, B}`      |

In the assignment, the left operand is strictly a variable and the right operand is an expression. The type of the variable is the type of the left operand. A side effect is storing the value on the right side into the variable. The automatic conversion cannot change the type of the variable, i.e., it is impossible to store `float` value in `int` variable.

We can use parentheses in expressions.

All operators (except `=`) have left associativity (`=` has right associativity), and their priority is (from lowest to highest):

1. `=`
2. `\|\|`
3. `&&`
4. `==`, `!=`
5. `<`, `>`
6. `+`, `-`, `.`
7. `*`, `/`, `%`
8. `!`
9. unary `-`
