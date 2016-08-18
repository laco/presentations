import scala.annotation.tailrec

object Sample104 extends App {

  @tailrec
  def repeat(f: Int => Int, n:Int, x: Int): Int = {
    if (n < 1) x
    else repeat(f, n - 1, f(x))  // OR? f(repeat(f, n - 1, x))
  }

  val p = repeat(x => x * x, 10, 2)  // (2*2) * (2 *2) * ...
  println(p)

}
