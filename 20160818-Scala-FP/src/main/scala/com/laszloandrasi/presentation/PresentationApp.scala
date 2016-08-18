package com.laszloandrasi.presentation

/**
  * Created by landrasi on 2016.08.17..
  */
object PresentationApp extends App {

  val presentation = Presentation("Functional Programming in Scala (Introduction)", creator=Some("László Andrási"))(
    Chapter("Case-Classes & Pattern matching",
      Slide(
          Title("In the previous episode..."), Paragraph("Simple Expressions, Objects, Classes, Traits")),
      Slide(
        Code(
        """trait SampleTrait {
          |  val foo = "bar"
          |}
        """.stripMargin),
        Code.fromFile("Sample001.scala")),
      Slide(Title("case classes", 3), Code.fromFile("Sample002.scala")),
      Slide(Title("the apply(...) method", 3), Code.fromFile("Sample003.scala")),
      Slide(Title("pattern matching", 3), Code.fromFile("Sample004.scala")),
      Slide(Title("pattern matching (2)", 3), Code.fromFile("Sample005.scala"))
    ),
    Chapter("function literals, Eta transformations",
      Slide(Title("Methods vs Functions", 3), Code.fromFile("Sample101.scala")),
      Slide(Title("Higher order functions" ,3), Code.fromFile("Sample102.scala")),
      Slide(Title("Anonymous functions", 3), Code.fromFile("Sample103.scala")),
      Slide(Title("Anonymous functions and recursion", 3), Code.fromFile("Sample104.scala"))
    ),
    Chapter("Currying",
      Slide(Title("Multiple parameter lists", 3), Code.fromFile("Sample201.scala"))
    ),
    Chapter("Lazy evaluation",
      Slide(Title("Call-by name arguments", 3), Code.fromFile("Sample301.scala")),
      Slide(Title("repeat Loop", 3), Code.fromFile("Sample302.scala")),
      Slide(Title("lazy vals", 3), Code.fromFile("Sample303.scala"))
    ),
    Chapter("Methods on collections",
      Slide(Title("map, filter, reduce", 4), Code.fromFile("Sample401.scala"))
    ),
    Chapter("Summary",
      Slide(
        Title("Scala is sometimes.."),
        Paragraph("Strange"),
        Paragraph("Elegant"),
        Paragraph("Fun")
      )))

  RevealJS.generate(presentation)
}
