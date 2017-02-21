package d.kh.scala.byname

import org.scalatest.FunSuite

/**
  * Created by khamitovdm on 17/02/2017.
  */
class MathTest extends FunSuite {
  test("Pass the wrong arithmetic expression by name so no exception thrown here - we intercept it and print to the system output") {
    Math.print(5 / 0)
  }
}
