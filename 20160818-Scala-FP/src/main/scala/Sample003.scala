class Person3(val firstName: String,
              val lastName: String)

object Person3 {
  def apply(firstName: String, lastName: String) =
    new Person3(firstName, lastName)
}

object Sample003 {
  val p = Person3("John", "Doe") // No new keyword!!!
}