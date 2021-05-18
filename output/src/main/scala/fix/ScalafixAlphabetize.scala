package fix

object ScalafixAlphabetize {
  trait T1 {
    def t1a: Unit
    def t1b: Unit
  }

  trait T2 {
    def t2x: Unit
  }

  def a = ()
  def b = ()

  private def c = ()

  def e = new T2 {
    override def t2x: Unit = ()
  }

  val d = new T1 {
    override def t1a: Unit = ()
    override def t1b: Unit = ()
  }
}
