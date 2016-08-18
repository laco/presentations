object Sample102 extends App {
  def identity(x: Int) = x
  def sqr(x: Int) = x * x
  def cube(x: Int) = x * x * x

  def fun(f: Int => Int, a: Int, b: Int): Int =
    if (a==b) f(a)
    else f(a) + fun(f, a + 1, b)

  println( fun(identity, 5, 4) )
  println( fun(sqr, 5, 5) )
  println( fun(cube, 10, 15) )
}
