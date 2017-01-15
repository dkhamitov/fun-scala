package d.kh.scala

import org.scalatest.FunSuite

/**
  * Created by khamitovdm on 16/01/2017.
  */
class ForAndFlatMapTest extends FunSuite {
  test("how for-expression can work similar to flatMap") {
    //given:
    case class Rabbit(name: String, color: String)
    def twiceRabbit(rabbit: Rabbit): List[Rabbit] = {
      List(rabbit, rabbit.copy(name = s"${rabbit.name} Junior"))
    }

    //when:
    val rabbits = List(Rabbit("X", "White"), Rabbit("Y", "Gray"))

    //then:
    assert((for (x <- rabbits; y <- twiceRabbit(x)) yield y) == rabbits.flatMap(twiceRabbit))
  }
}


