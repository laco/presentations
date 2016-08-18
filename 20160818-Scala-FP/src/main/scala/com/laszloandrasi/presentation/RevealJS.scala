package com.laszloandrasi.presentation

/**
  * Created by landrasi on 2016.08.17..
  */
object RevealJS {
  import ToHTML._

  def generate(p: Presentation, fileName: String = "revealjs/presentation.html") = {
    val presentationHtml = p.toHTML

    import java.nio.file.{Paths, Files}
    import java.nio.charset.StandardCharsets
    Files.write(Paths.get(fileName), presentationHtml.getBytes(StandardCharsets.UTF_8))
    println(s"Generated file $fileName")
  }
}
