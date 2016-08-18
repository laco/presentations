case class Person(firstName: String, lastName: String)
case class MutablePerson(var firstName: String, var lastName: String)

object Sample002 {
  val bud = Person("Bud", "Spencer")
  val terence = MutablePerson("Terence", "Hill")

  terence.firstName = "Zsugabubus" // call to a mutator
}