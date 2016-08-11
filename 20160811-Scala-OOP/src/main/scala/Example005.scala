
class Director(val firstName: String,
               val lastName: String,
               val yearOfBirth: Int) {

  def name: String =
    s"$firstName $lastName"

  def copy(
            firstName: String = this.firstName,
            lastName: String = this.lastName,
            yearOfBirth: Int = this.yearOfBirth): Director =
    new Director(firstName, lastName, yearOfBirth)
}

class Film(
            val name: String,
            val yearOfRelease: Int,
            val imdbRating: Double,
            val director: Director) {
  def directorsAge =
    yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) =
    this.director == director

  def copy(
            name: String = this.name,
            yearOfRelease: Int = this.yearOfRelease,
            imdbRating: Double = this.imdbRating,
            director: Director = this.director): Film =
    new Film(name, yearOfRelease, imdbRating, director)
}

object Example005 {

  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someBody = new Director("Just", "Some Body", 1990)
  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  assert(eastwood.yearOfBirth == 1930) // should be 1930
  assert(dieHard.director.name == "John McTiernan") // should be "John McTiernan"
  assert(!invictus.isDirectedBy(nolan)) // should be false

  val l = highPlainsDrifter.copy(name = "L'homme des hautes plaines")
  // returns Film("L'homme des hautes plaines", 1973, 7.7, /* etc */)
  val l1 =thomasCrownAffair.copy(yearOfRelease = 1968,
    director = new Director("Norman", "Jewison", 1926))
  // returns Film("The Thomas Crown Affair", 1926, /* etc */)

  val l2 = inception.copy().copy().copy()
  // returns a new copy of `inception`
}