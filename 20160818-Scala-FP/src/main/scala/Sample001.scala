class Sample001 {
  val x = 1
  var y = 1
}

object Sample001 {
  val foo = new Sample001()
  foo.y = 2
  println(foo.y)
}