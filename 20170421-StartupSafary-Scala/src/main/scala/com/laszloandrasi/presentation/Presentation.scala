package com.laszloandrasi.presentation

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}


sealed trait Section

final case class Chapter(title: String, sections: Section*) extends Section
final case class Slide(contents: Content*) extends Section
final case class MarkdownSlide(text: String) extends Section

sealed trait Content

final case class Title(title: String, size: Int = 2) extends Content
final case class Pre(text: String) extends Content
final case class Paragraph(text: String) extends Content
final case class Code(text: String) extends Content

object Code {
  import scala.collection.JavaConversions._

  def fromFile(fileName: String, prefixPath: String = "src/main/scala/"): Code = {
    Code(Files.readAllLines(Paths.get(prefixPath + fileName), StandardCharsets.UTF_8) mkString("\n") )
  }

}
case class Presentation(title: String, creator: Option[String] = None)(sections: Section*) {
  // def toHTML = startSection.toHTML + (sections.map(_.toHTML) mkString "\n")

  def startSection = Slide(
    Title(title, 1), Paragraph(s"by: ${creator.getOrElse("Anonymous")}")
  )
  val subSections = sections
}


