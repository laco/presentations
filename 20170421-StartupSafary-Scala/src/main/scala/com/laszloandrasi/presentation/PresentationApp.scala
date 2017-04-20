package com.laszloandrasi.presentation

/**
  * Created by landrasi on 2016.08.17..
  */
object PresentationApp extends App {

  val presentation =
    Presentation("A második legtöbbször félreértett programozás nyelv",
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
        MarkdownSlide(
          """
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
            | * Az első próbálkozások __Spark__-al -> ígéretesek.
            | * Elég könnyen bedőltünk a "hype"-nak
            | * Beláttuk, hogy a Spark sem oldja meg minden problémánkat (De van amit igen!)
            |
          """.stripMargin
        ),
        MarkdownSlide(
          """
            | 2016.11 - 2017.01
            | * A teljes csapat Scalaval dolgozik
            | * A rendszer jelentős részét átírtuk Scala-ra
            | * Python-al oda-vissza kompatibilítást megőrízve (JPype)
            | * Vegyes a kódbázis, de úgy tűnik, hogy a batch processinggel kapcsolatos problémákat megoldottuk
          """.stripMargin
        ),
        MarkdownSlide(
          """
            | 2017.02 - 2017.04
            |
            | * Új realtime komponens Akka-val -> az első eredmények ígéretesek
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
        Slide(Code.fromFile("Sample002.scala"))
      ),
      Chapter("Hogyan tovább?"),
      Chapter("A legidegesítőbb dolgok")
    )

  RevealJS.generate(presentation)
}
