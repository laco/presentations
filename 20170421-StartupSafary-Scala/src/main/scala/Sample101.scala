class Sample101 {
  def addMethod (a: Int, b: Int): Int = a + b
}

object Sample101 {
  val s = new Sample101()

  def add(a: Int, b: Int): Int = a + b
  val add2: (Int, Int) => Int = s.addMethod
  val add3 = s.addMethod _
  val add4 = (a: Int, b: Int) => a + b

  // val sumX = List.reduce(s.addMethod) // <- Not working

  val list = List(1, 2, 3, 4, 5)
  val sum1 = list.reduce(add)
  val sum2 = list.reduce(add2)
  val sum3 = list.reduce(add3)
  val sum4 = list.reduce(add4)

}
