package d.kh.scala.generator

import d.kh.scala.generator.Generator.{booleans, integers}

/**
  * Created by khamitovdm on 18/01/2017.
  */
trait Tree

case class Inner(left: Tree, right: Tree) extends Tree {
  override def toString: String = s"[$left, $right]"
}

case class Leaf(x: Int) extends Tree {
  override def toString: String = s"($x)"
}

object TreeGenerator {
  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leaves else inners
  } yield tree

  def leaves: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)

  def inners: Generator[Inner] = for {
    left <- trees
    right <- trees
  } yield Inner(left, right)
}
