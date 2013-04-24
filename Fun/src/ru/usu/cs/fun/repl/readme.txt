Простая консольная среда программирования.
Можно вводить выражения языка fun и они будут тут же выполняться, 
а результат выводиться на консоль.
Такие среды разработки называют REPL (Read—Eval—Print—Loop)

Подробнее о том, что такое REPL, откуда и зачем он появился можно почитать в википедии:
http://en.wikipedia.org/wiki/Read-eval-print_loop
let remove1 := fun (x) fun (y) fun (z) concat (substr x 0 y) (substr x z (len x));
let insert1 := fun (x) fun (y) fun (z) concat (concat (substr x 0 z) y) (substr x z (len x));