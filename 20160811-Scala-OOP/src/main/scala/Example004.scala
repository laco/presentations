/**
  * Created by landrasi on 2016.08.11..
  */

class ExampleClass

class Example2Class () {
  def foo = "bar"
  val baz = "yol"
  var p = "one"
}



object Example004 extends App {

  val x = new ExampleClass
  val y = new Example2Class
  val z = new Example2Class()

  println(y.foo)

  z.p = "two"
  println(z.p)
}
