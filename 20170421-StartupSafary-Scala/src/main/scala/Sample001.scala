package sample001

trait Human {
  def name: String
  def birthYear: Int
}

class Male(val name: String, val birthYear: Int) extends Human
class Female(val name: String, val birthYear: Int) extends Human

object UsefulFunctions {
  def age(h: Human, currentYear: Int): Int =
    currentYear - h.birthYear
}

object Main001 {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")
    val zoltan = new Male("Zoltan", 2011)
    val judit: Human = new Female("Judit", 1984)
    println(UsefulFunctions.age(zoltan, currentYear = 2017))
  }
}
