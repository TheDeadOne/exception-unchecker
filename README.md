# Exception Unchecker

Каждый java-программист ежедневно сталкивается с неудобством проверяемых исключений. Хотелось бы сделать так

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(URL::new)
.map(URL::getContent)
.forEach(System.out::println);
```

но не выйдет, компилятор выдаст ошибку

> incompatible thrown types MalformedURLException in method reference

И приходится городить что-нибудь вроде

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(s -> {
  try {
    return new URL(s);
  } catch (MalformedURLException exc) {
    throw new RuntimeException(exc);
  }
})
.map(url -> {
  try {
    return url.getContent();
  } catch (IOException exc) {
    throw new RuntimeException(exc);
  }
})
.forEach(System.out::println);
```

Мало того, что это выглядит ужасно, так ещё и маскирует исходное исключение. Как минимум в трассировке стека будут лишние элементы, а если это исключение нужно было перехватить в вызывающем коде, то понадобится очередная уродливая конструкция типа

```java
try {
  // Код предыдущего примера
} catch (RuntimeException exc) {
  if (exc.getCause() instanceof MalformedURLException) {
    // Обработка ошибки
  } else {
    throw exc;
  }
}
```

К счастью, проверяемые исключения - это явление времени компиляции, а для виртуальной машины все исключения одинаковы. Это даёт возможность обмануть компилятор, заворачивая лямбды, выбрасывающие проверяемые исключения, в лямбды, их не выбрасывающие.

Библиотека это как раз и делает, генерируя обёртки в рантайме с помощью [LambdaMetafactory]( https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/LambdaMetafactory.html). Например

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(FunctionWrapper.wrap(URL::new))
.map(SupplierWrapper.wrap(URL::getContent))
.forEach(System.out::println);
```

Для часто используемых функциональных интерфейсв есть хэлпер ещё больше упрощающий код

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(ExceptionUnchecker.uncheck(URL::new))
.map(ExceptionUnchecker.uncheck(URL::getContent))
.forEach(System.out::println);
```

И конечно, метод uncheck можно статически импортировать для ещё большей краткости.

&nbsp;

*На идею написания библиотеки натолкнул [вопрос на Stackoverflow](https://ru.stackoverflow.com/q/634549/204271)*
