# ScalaFix Alphabetize
![Github Actions](https://github.com/tusharmath/scalafix-alphabetize/actions/workflows/ci.yml/badge.svg)


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

From the `sbt` console 
```scala
scalafix https://raw.githubusercontent.com/tusharmath/scalafix-alphabetize/master/rules/src/main/scala/fix/ScalafixAlphabetize.scala
```
