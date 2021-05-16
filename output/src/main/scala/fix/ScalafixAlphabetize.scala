package fix

object ScalafixAlphabetize {
  trait A {
    def a: Unit
    def b: Unit
  }

  def a = ()
  def b = ()
  private def c = ()

  val d = new A {
    override def a: Unit = ()
    override def b: Unit = ()
  }
}
