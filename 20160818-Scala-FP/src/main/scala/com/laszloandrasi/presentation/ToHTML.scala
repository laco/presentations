package com.laszloandrasi.presentation

object ToHTML {

  implicit def presentation2presentationWithHtml(p: Presentation) = new HTMLPresentation(p)
  implicit def content2contentWithHtml(c: Content) = new HTMLContent(c)
  implicit def section2sectionWithHtml(s: Section) = new HTMLSection(s)


  val sectionStart = "<section>\n  "
  val sectionEnd = "</section>\n"

  class HTMLPresentation(val p: Presentation) {
    def toHTML: String = toHTML()

    def toHTML(ctx: Map[String, String] = Map()) = {
      htmlHeader(p, ctx) + p.startSection.toHTML +
      (p.subSections.map(_.toHTML) mkString "\n") + htmlFooter
    }
  }
  class HTMLContent(val c: Content) {
    def toHTML: String = c match {
      case Title(title, size) => s"<h${size}>$title</h${size}>"
      case Pre(text) => s"<pre>$text</pre>"
      case Paragraph(text) => s"<p>$text</p>"
      case Code(text) => s"<pre><code class='scala' data-trim>$text</code></pre>"
    }
  }

  class HTMLSection(val s: Section) {
    def toHTML: String = s match {
      case Chapter(title, sections @ _*) =>
        sectionStart +
          sectionStart + Title(title).toHTML + sectionEnd +
          (sections.map(_.toHTML) mkString "\n") +
          sectionEnd

      case MarkdownSlide(text) => s"<section data-markdown>\n${text}</section>\n"

      case Slide(contents @ _*) =>
        sectionStart + (contents.map(_.toHTML) mkString "\n") + sectionEnd
    }
  }

  def htmlHeader(p: Presentation, ctx: Map[String, String] = Map()) : String =
    s"""
      |<!doctype html>
      |<html lang="en">
      |
      |	<head>
      |		<meta charset="utf-8">
      |		<title>${p.title}</title>
      |		<meta name="author" content="${p.creator}">
      |
      |		<meta name="apple-mobile-web-app-capable" content="yes">
      |		<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
      |
      |		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
      |
      |		<link rel="stylesheet" href="css/reveal.css">
      |		<link rel="stylesheet" href="css/theme/${ctx.getOrElse("theme", "black")}.css" id="theme">
      |
      |		<!-- Theme used for syntax highlighting of code -->
      |		<link rel="stylesheet" href="lib/css/zenburn.css">
      |
      |		<!-- Printing and PDF exports -->
      |		<script>
      |			var link = document.createElement( 'link' );
      |			link.rel = 'stylesheet';
      |			link.type = 'text/css';
      |			link.href = window.location.search.match( /print-pdf/gi ) ? 'css/print/pdf.css' : 'css/print/paper.css';
      |			document.getElementsByTagName( 'head' )[0].appendChild( link );
      |		</script>
      |
      |		<!--[if lt IE 9]>
      |		<script src="lib/js/html5shiv.js"></script>
      |		<![endif]-->
      |	</head>
      |
      |	<body>
      |
      |		<div class="reveal">
      |
      |			<!-- Any section element inside of this container is displayed as a slide -->
      |			<div class="slides">
    """.stripMargin

  def htmlFooter : String =
    """
      |			</div>
      |
      |		</div>
      |
      |		<script src="lib/js/head.min.js"></script>
      |		<script src="js/reveal.js"></script>
      |
      |		<script>
      |
      |			// More info https://github.com/hakimel/reveal.js#configuration
      |			Reveal.initialize({
      |       margin: 0.01,
      |				controls: true,
      |				progress: true,
      |				history: true,
      |				center: true,
      |
      |				transition: 'slide', // none/fade/slide/convex/concave/zoom
      |
      |				// More info https://github.com/hakimel/reveal.js#dependencies
      |				dependencies: [
      |					{ src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
      |					{ src: 'plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
      |					{ src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
      |					{ src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
      |					{ src: 'plugin/zoom-js/zoom.js', async: true },
      |					{ src: 'plugin/notes/notes.js', async: true }
      |				]
      |			});
      |
      |		</script>
      |
      |	</body>
      |</html>
    """.stripMargin
}
