package d.kh.scala.generator

import d.kh.scala.generator.Generator.{integers, pairs}
import org.scalatest.FunSuite

/**
  * Created by khamitovdm on 17/01/2017.
  */
class GeneratorTest extends FunSuite {
  test("integers") {
    assert(integers.generate != integers.generate)
  }

  test("pairs") {
    assert(pairs(integers, integers).generate != pairs(integers, integers).generate)
  }
}
