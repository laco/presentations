/**
  * Created by landrasi on 2016.08.11..
  */

trait Blog {
    def showLength()
    override def toString: String
}

object Blog {
   def apply(article: String) : Blog = new BlogImpl(article)

   private class BlogImpl(private val article:String) extends Blog {
     def showLength() = article.length
     override def toString: String = article
   }
}

/* ------------------------- */

class MyStringBox(private val s: String) {
  override val toString: String = s
}


object MyStringBox {
  def toUpperCase(m: MyStringBox): MyStringBox = new MyStringBox(m.s.toUpperCase())

}


object Example010 extends App {

  // The implementation is hidden from the user (private modifier)

  var myBlog = Blog("Hello, hello!")  // no "new" keyword here?!
  println(myBlog.showLength())

  val m1 = new MyStringBox("abcd")
  val m1Upper = MyStringBox.toUpperCase(m1) // companion objects can access private members

  assert(m1Upper.toString == "ABCD")

}
