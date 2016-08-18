object Sample103 {
  def doTwice(f: Int=>Int, a: Int): Int = f(f(a))

  println( doTwice( x => x, 10))
  println( doTwice( x => x * 2, 10))
  println( doTwice( _ * 2, 10))

  val add: (Int, Int) => Int = _ + _
  println( add( 10, 20) )
}
