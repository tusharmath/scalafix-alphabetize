package fix

object ScalafixAlphabetize {
  trait T1 {
    
    

def t1a: Unit

def t1b: Unit
  }

  trait T2 {
    def t2x: Unit
  }

  
  
  
  
/**
    * this is a
    */
def a = ()
// this is b
def b = ()
/* this is c */
private def c = ()
/** this is e */
def e = new T2 {
    override def t2x: Unit = ()
  }

  
  

  
  

  /** this is d
    */
  val d = new T1 {
    
    

override def t1a: Unit = ()

override def t1b: Unit = ()
  }
}