object Sample302 extends App {

  def repeatLoop(com: => Unit)(con: => Boolean) {
    com
    if (con) repeatLoop(com)(con)
  }

  var x = 0
  repeatLoop {
    x += 1
    println(x)
  }(x < 10)

}
