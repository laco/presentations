import scala.annotation.tailrec

object Sample201 extends App{

  @tailrec
  def repeat(f: Long => Long)(n: Long)(x: Long): Long = {
    if (n < 1) x
    else repeat(f)(n - 1)(f(x))
  }

  val double = repeat(x => x + x) _ // if I left of this _ ->>>>
  val doubleX10 = repeat(x => x + x)(10) _

  println (double(10))
  println (doubleX10)
  println (doubleX10(2))
}
/*
->>>>
InError:(13, 22) missing argument list for method repeat in object Sample201
Unapplied methods are only converted to functions when a function type is expected.
  You can make this conversion explicit by writing `repeat _` or `repeat(_)(_)(_)` instead of `repeat`.
val double = repeat(x => x + x)t
*/
