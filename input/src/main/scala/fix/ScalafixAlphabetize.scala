/*
rule = ScalafixAlphabetize
 */
package fix

object ScalafixAlphabetize {
  trait A {
    def b: Unit
    def a: Unit
  }

  def b = ()
  def a = ()
  private def c = ()

  val d = new A {
    override def b: Unit = ()
    override def a: Unit = ()
  }
}
