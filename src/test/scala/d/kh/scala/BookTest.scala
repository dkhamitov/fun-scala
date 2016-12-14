package d.kh.scala

import org.scalatest.FunSuite

/**
  * Created by khamitovdm on 15/12/2016.
  */
class BookTest extends FunSuite {

  test("just iterate through multiple books and find a particular author") {
    val book1 = Book(title = "Effective Java", authors = List("Joshua Bloch"))
    val book2 = Book(title = "Concurrency in Practise", authors = List("Brian Goetz"))

    val books = List(book1, book2)

    assert(List(book1) == (for (b <- books; a <- b.authors if a startsWith "Joshua") yield b))
  }
}
