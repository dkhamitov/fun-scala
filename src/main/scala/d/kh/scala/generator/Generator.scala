package d.kh.scala.generator

import java.util.Random

/**
  * Created by khamitovdm on 17/01/2017.
  */
trait Generator[+T] {
  self =>

  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate)
  }

  def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate).generate
  }
}

object Generator {
  val integers = new Generator[Int] {
    val rand = new Random()

    override def generate: Int = rand.nextInt()
  }

  val booleans = new Generator[Boolean] {
    override def generate: Boolean = integers.generate > 0
  }

  //  val pairs = new Generator[(Int, Int)] {
  //    override def generate: (Int, Int) = (integers.generate, integers.generate)
  //  }

  def pairs[T, U](t: Generator[T], u: Generator[U]): Generator[(T, U)] = for {
    x <- t
    y <- u
  } yield (x, y)
}
