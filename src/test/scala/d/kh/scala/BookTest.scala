package d.kh.scala

import org.scalatest.FunSuite

/**
  * Created by khamitovdm on 15/12/2016.
  */
class BookTest extends FunSuite {
  test("just iterate through multiple books and find a particular author using a for-expression") {
    val book1 = Book(title = "Effective Java", authors = List("Joshua Bloch"))
    val book2 = Book(title = "Concurrency in Practise", authors = List("Brian Goetz"))

    val books = List(book1, book2)

    assert(List(book1.title) === (for (b <- books; a <- b.authors if a startsWith "Joshua") yield b.title))
  }

  test("just iterate through multiple books and find a particular author using high-order functions") {
    val book1 = Book(title = "Effective Java", authors = List("Joshua Bloch"))
    val book2 = Book(title = "Concurrency in Practise", authors = List("Brian Goetz"))

    val books = List(book1, book2)

    assert(List(book1.title) === books.flatMap(b => b.authors withFilter (a => a startsWith "Joshua") map (_ => b.title)))
  }

  test("find all the authors who has written at least 2 books") {
    val book1 = Book(title = "Effective Java", authors = List("Joshua Bloch"))
    val book2 = Book(title = "Concurrency in Practise", authors = List("Brian Goetz"))
    val book3 = Book(title = "Java Puzzlers", authors = List("Joshua Bloch"))
    val book4 = Book(title = "Java Puzzlers. Part 2", authors = List("Joshua Bloch"))

    val books = Set(book1, book2, book3, book4)

    assert(Set("Joshua Bloch") === Book.findAllAuthorsWithAtLeast2Books(books))
  }

  test("override PLUS operator") {
    val b1 = new Book("BOOK 1", Nil)
    val b2 = new Book("BOOK 2", Nil)
    assert(List(b1, b2) === b1 + b2)
  }
}
