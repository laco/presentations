/**
  * Created by landrasi on 2016.08.10..
  */

trait Element

case class RowLayout(left: Element, right: Element) extends Element
case class ColumnLayout(top: Element, bottom: Element) extends Element
case class PlainText(text: String) extends Element
case class BulletList(bullets: String*) extends Element

trait Slide

case class StartSlide(title: String) extends Slide
case object EmptySlide extends Slide
case class ContentSlide(title: String, element: Element) extends Slide
case class Example(exampleObj: AnyRef, comment: String) extends Slide


class Presentation(slides: Slide*)


object MyApp extends App {

  val scalaOOP = new Presentation(
    StartSlide("Scala OOP Introduction"),
    EmptySlide,
    ContentSlide("Agenda",
      ColumnLayout(
        BulletList(
          "The Goal of this talk",
          "Why Scala?",
          "Good to know things",
          "OOP tools (classes, objects, traits)"
        ),
        BulletList(
          "Traits with default implementations",
          "Multi-trait inheritance",
          "Companion objects",
          "Case-Classes & Pattern matching"
        )
      )),
    EmptySlide,

    /* The goal */
    ContentSlide("Learning a new PL (by Dan Grossman)",
      BulletList(
        "Syntax: How do you write language constructs?",
        "Semantics: What do programs mean? (Evaluation rules)",
        "Idioms: What are typical patterns for using language features to express your computation?",
        "Libraries: What facilities does the language (or a well-known project) provide “standard”? " +
          "(E.g., file access, data structures)",
        "Tools: What do language implementations provide to make your job easier?" +
          "(E.g., REPL, debugger, code formatter, ...)"
      )),

    ContentSlide("Why Scala?",
      BulletList(
        "A `modern`, `big-data`, strongly typed JVM language",
        "Especially good for the problems we currently have (BSP)",

        "The best thing about Scala: As an everyday scala developer" +
          "I can use the same tools/tricks/{language constructs} as the scala creators." +
          "aka. (implicit parameters, implicit type conversion, type classes, etc.)"

    )),

    ContentSlide("About the install/tooling",
      BulletList(
        "Scala can be installed to everywhere Java7/8 can be installed",
        "Ubuntu like distributions: add a repository, apt-get update, apt-get install...",
        "Scala compiler",
        "sbt  (Scala Build Tool) 8>",
        "For a better programmer experience an IDE is required :(",
        "Eclipse or IDEA"
      )),

    EmptySlide,
    /* Some examples */

    Example(Example001, "hello world"),
    Example(None /* Example002.sc worksheet */, "expressions, hey plz. talk about compiletime vs runtime errors"),

    ContentSlide("Objects",
      BulletList(
        "Super easy way to create singleton objects",
        "Who thinks singleton objects are bad?"
      )),
    Example(Example003, "some object"),

    ContentSlide("Classes",
      BulletList(
        "in most cases same as in Java (because of interop.)",
        "less boilerplate",
        ""
      )),
    Example(Example004, "basic classes"),
    Example(Example005, "film database"),
    Example(Example006, "counter"),
    Example(Example007, "class inheritance"),

    ContentSlide("traits",
      BulletList(
        "interfaces",
        "with default optional default implementation"
    )),
    Example(Example008, "traits"),
    Example(Example009, "multi-trait"),

    ContentSlide("Companion objects",
      BulletList(
        "in Scala: no static methods in classes",
        "but we have companion objects"
      )),

    Example(Example010, "companion object"),
    Example(this, "case classes!")
  )

}

