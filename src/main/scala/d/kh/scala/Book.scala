package d.kh.scala

/**
  * Created by khamitovdm on 15/12/2016.
  */
case class Book(title: String, authors: List[String]) {
  def +(b: Book): List[Book] = List(this, b)
}

object Book {
  /**
    * @param books must meet the requirement that any author may appear at most 2 times. Otherwise, the behaviour
    *              of the method is undefined
    * @return
    */
  def findAllAuthorsWithAtLeast2Books(books: Set[Book]): Set[String] = {
    for {
      b1 <- books
      b2 <- books
      if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    } yield a1
  }
}
