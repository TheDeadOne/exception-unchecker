# Exception Unchecker

Every java programmer faces the inconvenience of checked exceptions daily. We want something like this

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(URL::new)
.map(URL::getContent)
.forEach(System.out::println);
```

but it won't work, the compiler will throw an error

> incompatible thrown types MalformedURLException in method reference

And we have to crutch something like

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

It looks awful and it hides the original exception. At least there will be extra elements in the stack trace, and if this exception had to be caught in the calling code, then another ugly crutch appear

```java
try {
  // Code from the previous example
} catch (RuntimeException exc) {
  if (exc.getCause() instanceof MalformedURLException) {
    // Exception handling
  } else {
    throw exc;
  }
}
```

Fortunately, checked exceptions are a compile-time phenomenon, and for a virtual machine, all exceptions are the same. This makes it possible to trick the compiler by wrapping lambdas that throw checked exceptions into lambdas that do not throw them.

This is exactly what the library does by generating wrappers at runtime with [LambdaMetafactory]( https://docs.oracle.com/javase/8/docs/api/java/lang/invoke/LambdaMetafactory.html). For example

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(FunctionWrapper.wrap(URL::new))
.map(SupplierWrapper.wrap(URL::getContent))
.forEach(System.out::println);
```

For frequently used functional interfaces, there is a helper to simplify the code even more

```java
Stream.of(
  "http://example.com",
  "http://google.com"
)
.map(Helper.uncheck(URL::new))
.map(Helper.uncheck(URL::getContent))
.forEach(System.out::println);
```

And of course, the `uncheck` method can be statically imported for even more brevity.

&nbsp;

*The idea of writing the library came from a [question on Stackoverflow](https://ru.stackoverflow.com/q/634549/204271)*
