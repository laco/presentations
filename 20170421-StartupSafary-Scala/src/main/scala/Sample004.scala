object Sample004 extends App {

  def fun(a: List[Int]) = a match {
    case List(0, p, q) => p + q
    case _ => -1
  }

  println(fun(List(0, 10, 20)))
  println(fun(List(0, 1, 2, 3)))
  println(fun(List(1, 10, 20)))
  println(fun(List()))

}
