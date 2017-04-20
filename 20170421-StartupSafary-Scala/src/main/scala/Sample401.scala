object Sample401 extends App {
  val a = 1 to 10 // what? 1.to(10)
  val b = 1 until 10

  println(a)
  println(b)

  val r1 = a.map(x => x * x)
  val r2 = a.reduce((x, y) => x + y) // or sum() is pre defined...
  val r3 = a.filter(x => x < 5)

  val r4 = b
    .map(x => x * x)
    .filter(x => x % 2 == 0)
    .reduce((x, y) => x + (y * 2))

  println((r1, r2, r3, r4))
}
