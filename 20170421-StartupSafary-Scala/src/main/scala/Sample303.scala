object Sample303 extends App {
  class Counter(var i: Int = 0) {
    def inc: Unit = i = i + 1
    def next = i + 1
    val next2 = i + 1
    lazy val next3 = i + 1
    var z = false
  }

  val c1 = new Counter(10)
  c1.inc
  println((c1.next, c1.next2, c1.next3))
  c1.inc
  println((c1.next, c1.next2, c1.next3))
  c1.inc
  println((c1.next, c1.next2, c1.next3))

}
