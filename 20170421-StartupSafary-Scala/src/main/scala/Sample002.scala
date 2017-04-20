package sample002

sealed trait Human {
  def name: String
  def birthYear: Int
  def age(implicit currentYear: Int): Int =
    currentYear - birthYear
}

case class Male(name: String, birthYear: Int) extends Human
case class Female(name: String, birthYear: Int) extends Human

object Main002 extends App {
  implicit val currentYear = 2017
  val zoltan = Male("Zoltan", 2011)
  val judit = Female("Judit", 1984)
  println(zoltan.age)
}
