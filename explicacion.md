Para demostrar que \( (f(n) - g(n)) \) pertenece a \( \Omega(f(n)) \) cuando \( f(n) > g(n) \), necesitamos encontrar constantes \( C \) y \( n_0 \) tales que:

\[ (f(n) - g(n)) \geq C \cdot f(n) \]

para todos \( n \geq n_0 \).

### Contraejemplo

Vamos a analizar el contraejemplo que has proporcionado:

\[ f(n) = n^2 \]
\[ g(n) = n^2 - n \]

Primero, verifiquemos que \( f(n) > g(n) \):

\[ n^2 > n^2 - n \]

Esto es verdadero para todos \( n > 0 \).

Ahora, calculemos \( f(n) - g(n) \):

\[ f(n) - g(n) = n^2 - (n^2 - n) = n \]

Queremos demostrar que \( n \) pertenece a \( \Omega(n^2) \). Esto significa que necesitamos encontrar constantes \( C \) y \( n_0 \) tales que:

\[ n \geq C \cdot n^2 \]

para todos \( n \geq n_0 \).

### Análisis

Para que esta desigualdad sea verdadera, necesitamos que:

\[ n \geq C \cdot n^2 \]

Dividimos ambos lados por \( n \) (asumiendo \( n > 0 \)):

\[ 1 \geq C \cdot n \]

Esto implica que:

\[ C \leq \frac{1}{n} \]

Para que esta desigualdad sea verdadera para todos \( n \geq n_0 \), \( C \) debe ser menor o igual a \( \frac{1}{n} \) para todos \( n \geq n_0 \). Sin embargo, esto no es posible porque \( \frac{1}{n} \) se vuelve arbitrariamente pequeño a medida que \( n \) crece.

### Conclusión

No podemos encontrar una constante \( C \) que satisfaga la desigualdad \( n \geq C \cdot n^2 \) para todos \( n \geq n_0 \). Por lo tanto, \( n \) no pertenece a \( \Omega(n^2) \).

### Resumen

- El contraejemplo \( f(n) = n^2 \) y \( g(n) = n^2 - n \) muestra que \( f(n) - g(n) = n \).
- Para demostrar que \( n \) pertenece a \( \Omega(n^2) \), necesitamos encontrar constantes \( C \) y \( n_0 \) tales que \( n \geq C \cdot n^2 \) para todos \( n \geq n_0 \).
- Sin embargo, esto no es posible porque \( \frac{1}{n} \) se vuelve arbitrariamente pequeño a medida que \( n \) crece.

Por lo tanto, el contraejemplo demuestra que la afirmación \( f(n) > g(n) \implies (f(n) - g(n)) \in \Omega(f(n)) \) no es verdadera en general.
