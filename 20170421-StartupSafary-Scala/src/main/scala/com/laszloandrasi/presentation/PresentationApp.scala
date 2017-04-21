package com.laszloandrasi.presentation

/**
  * Created by landrasi on 2016.08.17..
  */
object PresentationApp extends App {

  val presentation =
    Presentation("A második legtöbbször félreértett programozási nyelv",
                 creator = Some("Andrási László"))(
      Chapter(
        "Miért a Scala?",
        MarkdownSlide(
          """
            |### A környezet amiben egy mai szoftvernek működnie kell:
            |
            | * multi-core gépek
            | * hálózatba kötve
            | * nagy rendelkezésre állás
            | * párhuzamos számítások
            | * osztott adattárolás (shard, replica)
            | * automatizált deployment
            |
            |Olyan _eszközök_ kellenek, amikkel halandó emberek is tudnak _megbízható_ szoftvereket készíteni.
          """.stripMargin),
        MarkdownSlide(
          """
            |### Egy programozási nyelv választása már nem csak a szintaxisról szól
            |
            | * standard library
            |   * filekezelés, http, threadek, dátum-kezelés!!! ...)
            | * __közösség__ által fejlesztett _up-to-date_ package-ek, lib-ek
            | * transpile to JavaScript :)
            | * clean code, fenntartható több emberes projektek
            |   * teszt keretrendszerek
            |   * linterek
            |   * build toolok
            | * performancia
          """.stripMargin)
      ),
      Chapter(
        "A mi történetünk...",
        MarkdownSlide(
          """
            | Rendszergazdák tevékenységeit naplózzuk és **elemezzük**, _valós időben_ is.
            | Kétféle folyamat van a rendszerünkben:
            |
            |* batch process
            |   * sok adatot igényelő
            |   * hosszú számítások
            |   * nem fér be a memóriába (big data?)
            |* realtime process
            |   * kevesebb adatot igénylő
            |   * kritikus a gyors eredmény
            |   * jajj, csak a diskhez ne kelljen nyúlni...
            |
          """.stripMargin
        ),
        MarkdownSlide(
          """
            | Scala-val mind a kettőre vannak eszközök, plusz ott teljes Java stack..
            |
            | batch process -> __Spark__
            |
            | realtime process -> __Akka__
            |
          """.stripMargin
        ),
        MarkdownSlide("""
            | 2016.04. - 2016.06.
            |
            | * Python kódbázis (Pandas, Numpy)
            | * Nem tudjuk kihasználni a hardvert
            | * mindig csak egy magon fut minden python process
            | * Lassúak vagyunk, és ráadásul néha elfogy a memória
            | * Nehezen tudunk párhuzamosítani
          """.stripMargin),
        MarkdownSlide(
          """
            | 2016.06. - 2016.10.
            |
            | * Néhányan a csapatből elkezdünk ismerkedni a Scala-val (coursera)
            | * Az első próbálkozások __Spark__-al
            | * Elég könnyen bedőltünk a "hype"-nak
            | * Beláttuk, hogy a Spark sem oldja meg minden problémánkat (De van amit igen!)
            |
          """.stripMargin
        ),
        MarkdownSlide(
          """
            | 2016.11 - 2017.01
            | * A teljes csapat Scala-val dolgozik
            | * A rendszer jelentős részét átírtuk Scala-ra
            | * Python-al oda-vissza kompatibilítást megőrízve (JPype)
            | * Vegyes a kódbázis, de úgy tűnik, hogy a batch processinggel kapcsolatos problémákat megoldottuk
          """.stripMargin
        ),
        MarkdownSlide(
          """
            | 2017.02 - 2017.04
            |
            | * Új realtime komponens Akka-val
          """.stripMargin
        ),
        MarkdownSlide(
          """
            | 2017.06 - Dobjuk a Python kompatibilítást
          """.stripMargin
        )
      ),
      Chapter(
        "Scala gyorstalpaló",
        Slide(Code.fromFile("HelloWorld.scala")),
        Slide(Code.fromFile("Sample001.scala")),
        Slide(Code.fromFile("Sample002.scala")),
        Slide(
          Title("the body of the class is the constructor"),
          Code("""
            |class Hello(name: String) {
            |  // Statement executed as part of the constructor
            |  println("New instance with name: " + name)
            |
            |  // Method which accesses the constructor argument
            |  def sayHello = println("Hello, " + name + "!")
            |}
          """.stripMargin)
        ),
        Slide(
          Title("objects instead of static methods"),
          Code("""
            |class Hello(name: String) {
            |  def sayHello = println("Hello, " + name + "!")
            |}
            |
            |// Companion object of class Hello
            |object Hello {
            |  // Factory method
            |  def apply(name: String) = new Hello(name)
            |}
          """.stripMargin)
        ),
        Slide(
          Title("operators are just methods"),
          Code("""
            |val a = 23
            |val b = 65
            |
            |// + is a method in class Int, which can be called using
            |// the regular method call syntax...
            |val sum1 = a.+(b)
            |
            |// ... or using the infix syntax
            |val sum2 = a + b
            |
            |// You can use infix syntax with any method that takes one parameter
            |val result = List(2, 5, 13, 8) contains 4
          """.stripMargin)
        ),
        Slide(
          Title("higher order functions"),
          Code(
            """
            |def sum(f: Int => Int, a: Int, b: Int): Int =
            |  if (a > b) 0
            |  else f(a) + sum(f, a + 1, b)
            |
            |def cube(x: Int): Int = x * x * x
            |def id(x: Int): Int = x
            |
            |def sumInts(a: Int, b: Int) = sum(id, a, b)
            |def sumCubes(a: Int, b: Int) = sum(cube, a, b)
            |def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)
            |
            |def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
            |// just syntactic sugar ... { def f(x1: T1, …, xn: Tn) = e ; f }
            |
          """.stripMargin)
        ),
        Slide(
          Title("scala.collection"),
          Code("""
            |val numbers = List(1, 2, 3, 4)
            |
            |numbers.map((i: Int) => i * 2)  // List(2, 4, 6, 8)
            |numbers.filter((i: Int) => i % 2 == 0)  // List(2, 4)
            |
            |List(1, 2, 3).zip(List("a", "b", "c"))
            |// res0: List[(Int, String)] = List((1,a), (2,b), (3,c))
            |
            |// partition, find, drop, fold, flatten, flatMap
          """.stripMargin)
        ),
        Slide(
          Title("scala.collection"),
          Code("""
            |val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)
            |
            |extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)
            |// res0: scala.collection.immutable.Map[String,Int] =
            |// Map((steve,100), (bob,101))
            |
            |/*
            |  mutable and immutable collections
            |  parallel collections
            |*/
          """.stripMargin)
        ),
        Slide(
          Title("tail recursion 1."),
          Code("""
            |// a wrong example
            |def factorial(number:Int) : Int = {
            |  if (number == 1) 1
            |  else number * factorial(number - 1)
            |}
          """.stripMargin)
        ),
        Slide(
          Title("tail recursion 2."),
          Code("""
            |// a better example
            |def factorial(number: Int) : Int = {
            |  @tailrec
            |  def factorialWithAcc(acc: Int, number: Int) : Int = {
            |    if (number == 1) acc
            |    else factorialWithAcc(acc * number, number - 1)
            |  }
            |  factorialWithAcc(1, number)
            |}
          """.stripMargin)
        ),
        Slide(
          Title("call by name parameters 1."),
          Code("""
            |def x: Unit = { some side-effect }
            |
            |def callByValue(x : Unit) = {
            |  // do nothing with x
            |}
            |
            |def callByName(x : => Unit) = {
            |  // do nothing with x
            |}
          """.stripMargin)
        ),
        Slide(
          Title("call by name parameters 2."),
          Code("""
            |def x: Unit = { some side-effect }
            |
            |def callByValue(x : Unit) = {
            |  for (i <- 0 until 5) {
            |    print(x)
            |  }
            |} // x evaluated 1 times
            |
            |def callByName(x : => Unit) = {
            |  for (i <- 0 until 5) {
            |    print(x)
            |  }
            |} // x evaluated 5 times
          """.stripMargin)
        ),
        Slide(
          Title("lazy evaluation"),
          Code("""
            |object VarApp extends App {
            |  lazy val number = { println("Variable number is initialized."); 99 }
            |  println("Before Accessing 'number' variable:")
            |  println(number + 1)
            |  println(number + 1)
            |  println(number + 1)
            |}
          """.stripMargin)
        ),
        Slide(
          Title("methods can have multiple parameter lists"),
          Code(
            """
            |def add(x: Int)(y: Int) = x + y
            |
            |// The method add2 has no parameter list; it fills in
            |// only the first parameter list of the method add
            |def add2 = add(2) _
            |
            |// Call add2, which returns a function that takes one parameter,
            |// then call that function with the argument 3
            |val result = add2(3)
          """.stripMargin)
        ),
        Slide(
          Title("you can define methods inside methods"),
          Code("""
            |def sum(xs: List[Int]): Int = {
            |  // Nested helper method
            |  def helper(accu: Int, rest: List[Int]): Int = rest match {
            |    case Nil => accu
            |    case _   => helper(accu + rest.head, rest.tail)
            |  }
            |
            |  // Call the nested helper method
            |  helper(0, xs)
            |}
          """.stripMargin)
        ),
        MarkdownSlide("""
            |### Amikre nem maradt idő...
            |
            | * pattern matching
            | * generic programming (A Scala type system király!)
            | * your own Domain Specific Language
            | * ...
          """.stripMargin)
      ),
      Chapter(
        "Ha meg akarod ismerni?",
        Slide(
          Title("www.coursera.org<br/>" +
            "/specializations/scala")),
        Slide(Title("Köszi! Kérdések?"),
              Paragraph("laszlo.andrasi @ balabit.com"),
              Paragraph("twitter: @a_laco"))
      )
    )

  RevealJS.generate(presentation)
}
