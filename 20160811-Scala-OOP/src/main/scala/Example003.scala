
object Example003 extends App {
  /* hey this thing is already an object, nesting is OK? WTF? */

  object TheMostUselessObjectEver

  object SampleObject {
    val sampleField: Int = 10
    var changeMe: String = "OK"

    def sampleMethod(): Unit = {
      println("nothing to do here")
    }

    def add(x: Int, y: Int): Int = {
      x + y  // no return statement required
    }

    override def toString: String = s"My state is: $sampleField and $changeMe"
  }

  object SampleCallableObject extends  {
    val n1: List[Int] = List(1,2,3)
    var n2: List[Int] = List(1,2,3)

    def apply(): List[Int] = {
      n1 ++ n2
    }
  }
  /* access object methods and fields */

  println(SampleObject.sampleField)
  SampleObject.sampleMethod()
  SampleObject.sampleMethod

  println(SampleObject)
  SampleObject.changeMe = "NOT OK"
  println(SampleObject)

  println(SampleObject.add(2, 2))
}

