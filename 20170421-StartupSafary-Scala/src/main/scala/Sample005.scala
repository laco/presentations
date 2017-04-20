/*
object Sample005 extends App {
  def sum(l: List[Int]): Int = l match {
    case Nil => 0
    case head :: tail => head + sum(tail)
  }

  def fun(p: Person) = p match {
    case Person(firstName, _) if firstName == "Bud" => "Rumosdió"
    case Person(_, lastName)  if lastName.length > 5 => "Kávé"
    case _ => "Pisztácia"
  }

  println(fun(Person("Terence", "Hill")))
  println(fun(Person("Nimphas", "Corporation")))
  println(fun(Person("Bruce", "Lee")))
}
*/
