/**
  * Created by landrasi on 2016.08.11..
  */

class BaseClass(val baseProperty: String) {
  override def toString: String = "basetoString"
}


class ChildClass(val childProperty: String) extends BaseClass("foo") {
  override def toString: String = baseProperty + " " + childProperty
}


object ChildObject extends BaseClass("baz") {
  override def toString: String = super.toString
}


object Example007 extends App {

  val o = new ChildClass("bar")
  assert(o.toString == "foo bar")


  assert(ChildObject.toString == "basetoString")
}
