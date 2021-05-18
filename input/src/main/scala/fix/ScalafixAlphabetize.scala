/*
rule = ScalafixAlphabetize
 */
package fix

object ScalafixAlphabetize {
  trait T1 {
    def t1b: Unit
    def t1a: Unit
  }

  trait T2 {
    def t2x: Unit
  }

  def b = ()
  def a = ()

  def e = new T2 {
    override def t2x: Unit = ()
  }

  private def c = ()

  val d = new T1 {
    override def t1b: Unit = ()
    override def t1a: Unit = ()
  }
}
