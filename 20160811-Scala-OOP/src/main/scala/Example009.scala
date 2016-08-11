
trait canDance {
  def dance() = {
    println("I'm dancing")
  }
}

trait canWalk {
  var walkedSteps: Int = 0
  def walk(steps: Int) = {
    walkedSteps += steps
  }
}


trait canTalk {
  def talk(sentence: String): Unit = {
    println(s"I say: ${sentence}")
  }
}

trait canSing {
  def sing(sentence: String): Unit = {
    println(s"I sing: ${sentence}")
  }
}

class People(val name: String)

class Dancer(override val name: String) extends People(name) with canDance with canWalk

class Singer(override val name: String) extends People(name) with canTalk with canSing

object PhilCollins extends People("Phil Collins") with canDance with canWalk with canTalk with canSing {
  def justStanding = true
  def sellingEverything = true
}

object Example009 extends App /* <- click here my friend */ {
  PhilCollins.walk(10)
  PhilCollins.sing("I can't sing.")
}
