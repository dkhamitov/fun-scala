package d.kh.scala.generator

import org.scalatest.FunSuite

/**
  * Created by khamitovdm on 18/01/2017.
  */
class TreeGeneratorTest extends FunSuite {
  test("leaves") {
    assert(TreeGenerator.leaves.generate match {
      case Leaf(_: Int) => true
    })
  }

  test("inners") {
    assert(TreeGenerator.inners.generate match {
      case Inner(_: Tree, _: Tree) => true
    })
  }

  test("trees") {
    assert(TreeGenerator.trees.generate match {
      case Inner(_: Tree, _: Tree) | Leaf(_: Int) => true
    })
  }

}
