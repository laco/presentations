object Sample301 extends App{
  def something() = { println("calling something"); 1 } // return value

  def callByValue(x: Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }
  println("call by value:")
  callByValue(something())

  println("call by name:")
  callByName(something())


}
