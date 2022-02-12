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

  // this is b
  def b = ()
  /**
    * this is a
    */
  def a = ()

  /** this is e */
  def e = new T2 {
    override def t2x: Unit = ()
  }

  /* this is c */
  private def c = ()

  /** this is d
    */
  val d = new T1 {
    override def t1b: Unit = ()
    override def t1a: Unit = ()
  }
}
