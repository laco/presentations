trait ExampleTrait

/* traits as base interface */

trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

class Rectangle(width: Double, height: Double) extends Shape {
  val sides = 4
  val perimeter = 2 * width + 2 * height
  val area = width * height
}

/* traits define types */

class ShapeBox(shape: Shape) {
  def myShapeArea = shape.area

}

object Example008 {
  val (example1, example2) = (new ShapeBox(new Circle(1.0)),
    new ShapeBox(new Rectangle(1.0, 1.0)))
}
