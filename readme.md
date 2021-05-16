# Alphabetize

Alphabetically sorts the methods in a file

# Example

**Input**

```scala
trait A {
  def b: Unit
  def a: Unit
}
```

**Output**

```scala
trait A {
  def a: Unit
  def b: Unit
}
```

# Usage

```scala
sbt
> scalafix https://raw.githubusercontent.com/tusharmath/scalafix-alphabetize/master/rules/src/main/scala/fix/ScalafixAlphabetize.scala
```
