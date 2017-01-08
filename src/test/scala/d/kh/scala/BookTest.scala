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

  test("find all the authors who has written more than 2 books") {
    val book1 = Book(title = "Effective Java", authors = List("Joshua Bloch"))
    val book2 = Book(title = "Concurrency in Practise", authors = List("Brian Goetz"))
    val book3 = Book(title = "Java Puzzlers", authors = List("Joshua Bloch"))

    val books = List(book1, book2, book3)

    assert(List("Joshua Bloch") == Book.findAllAuthorsWith2Books(books))
  }
}
