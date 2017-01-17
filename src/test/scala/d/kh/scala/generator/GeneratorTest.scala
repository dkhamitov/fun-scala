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

  test("single") {
    assert(Generator.single(5).generate === 5)
  }

  test("choose") {
    val generated = Generator.choose(1, 10).generate
    assert(generated > 1 && generated < 10)
  }

  test("oneOf") {
    val generated = Generator.oneOf(1, 10, 100).generate
    assert(List(1, 10, 100).contains(generated))
  }
}
