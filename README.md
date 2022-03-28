[Условия домашних заданий](https://www.kgeorgiy.info/courses/prog-intro/homeworks.html)


## Домашнее задание 13. Обработка ошибок

Модификации
* *Base*
    * Класс `ExpressionParser` должен реализовывать интерфейс
      [Parser](java/expression/exceptions/Parser.java)
    * Классы `CheckedAdd`, `CheckedSubtract`, `CheckedMultiply`,
      `CheckedDivide` и `CheckedNegate` должны реализовывать интерфейс
      [TripleExpression](java/expression/TripleExpression.java)
    * Нельзя использовать типы `long` и `double`
    * Нельзя использовать методы классов `Math` и `StrictMath`
    * [Исходный код тестов](java/expression/exceptions/ExceptionsTest.java)
        * Первый аргумент: `easy` или `hard`
        * Последующие аргументы: модификации
* *PowLog* 
    * Дополнительно реализуйте бинарные операции (максимальный приоритет):
        * `**` – возведение в степень, `2 ** 3` равно 8;
        * `//` – логарифм, `10 // 2` равно 3.
* *Shifts* 
    * Дополнительно реализуйте бинарные операции с минимальным приоритетом:
        * `<<` – сдвиг влево (`1 << 5 + 3` равно `1 << (5 + 3)` равно 256);
        * `>>` – сдвиг вправо (`1024 >> 5 + 3` равно `1024 >> (5 + 3)` равно 4);
        * `>>>` – арифметический сдвиг вправо (`-1024 >>> 5 + 3` равно `1024 >>> (5 + 3)` равно -4);
* *MinMax* 
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `min` – минимум, `2 min 3` равно 2;
        * `max` – максимум, `2 max 3` равно 3.
* *Abs* 
    * Дополнительно реализуйте унарную операцию
        * `abs` – модуль числа, `abs -5` равно 5.
* *Zeroes* 
    * Дополнительно реализуйте унарные операции
        * `l0` – число старших нулевых бит, `l0 123456` равно 15;
        * `t0` – число младших нулевых бит, `t0 123456` равно 6.


## Домашнее задание 12. Разбор выражений

Модификации
* *Base*
    * Класс `expression.parser.ExpressionParser` должен реализовывать интерфейс
      [Parser](java/expression/parser/Parser.java)
    * Результат разбора должен реализовывать интерфейс
      [TripleExpression](java/expression/TripleExpression.java)
    * [Исходный код тестов](java/expression/parser/ParserTest.java)
        * Первый аргумент: `easy` или `hard`
        * Последующие аргументы: модификации
* *Shifts* 
    * Дополнительно реализуйте бинарные операции с минимальным приоритетом:
        * `<<` – сдвиг влево (`1 << 5 + 3` равно `1 << (5 + 3)` равно 256);
        * `>>` – сдвиг вправо (`1024 >> 5 + 3` равно `1024 >> (5 + 3)` равно 4);
        * `>>>` – арифметический сдвиг вправо (`-1024 >>> 5 + 3` равно `1024 >>> (5 + 3)` равно -4);
* *MinMax* 
    * Дополнительно реализуйте бинарные операции (минимальный приоритет):
        * `min` – минимум, `2 min 3` равно 2;
        * `max` – максимум, `2 max 3` равно 3.
* *Zeroes* 
    * Дополнительно реализуйте унарные операции
        * `l0` – число старших нулевых бит, `l0 123456` равно 15;
        * `t0` – число младших нулевых бит, `t0 123456` равно 6.


## Домашнее задание 11. Выражения

Модификации
* *Base*
    * Реализуйте интерфейс [Expression](java/expression/Expression.java)
    * [Исходный код тестов](java/expression/ExpressionTest.java)
        * Первый аргумент: `easy` или `hard`
        * Последующие аргументы: модификации
* *Triple* 
    * Дополнительно реализуйте поддержку выражений с тремя переменными: `x`, `y` и `z`.
    * Интерфейс [TripleExpression](java/expression/TripleExpression.java).
* *BigInteger* 
    * Дополнительно реализуйте вычисления в типе `BigInteger`.
    * Интерфейс [BigIntegerExpression](java/expression/BigIntegerExpression.java).
* *BigDecimal*
    * Дополнительно реализуйте вычисления в типе `BigDecimal` .
    * Интерфейс [BigDecimalExpression](java/expression/BigDecimalExpression.java).
