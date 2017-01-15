package d.kh.scala

import org.scalatest.FunSuite

/**
  * Created by khamitovdm on 16/01/2017.
  */
class WithFilterTest extends FunSuite {
  test("apply withFilter in a for-expression") {
    //given:
    def toTheRightOfC(c: Char): Boolean = c > 'c'

    //then:
    val abcde = "abcde"
    assert((for (c <- abcde if toTheRightOfC(c)) yield c) === (for (c <- abcde withFilter toTheRightOfC) yield c))
  }
}
