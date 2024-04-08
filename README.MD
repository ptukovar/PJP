*   **`|` (Alternativa)**: Umožňuje výběr mezi několika možnostmi, například `add | sub` znamená, že lze použít buď `add` nebo `sub`.
*   **`*` (Kleeneho hvězda)**: Nulový nebo více výskytů, například `digit*` znamená, že `digit` se může objevit nula nebo vícekrát.
*   **`+` (Plus)**: Jeden nebo více výskytů, například `digit+` znamená, že `digit` se musí objevit alespoň jednou.
*   **`?` (Otazník)**: Nulový nebo jeden výskyt, například `digit?` znamená, že `digit` se může objevit nula nebo jednou.
*   **`()` (Závorky)**: Používají se k seskupení prvků, například `(a | b) c` znamená, že po `a` nebo `b` musí následovat `c`.