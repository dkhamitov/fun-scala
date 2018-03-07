package d.kh.scala.conversion

import org.scalatest.WordSpecLike

/**
  * Created by khamitovdm on 22/02/2017.
  */
class StringConverterTest extends WordSpecLike with StringConverter {
  "-Scala + -Java" must {
    "be equal to -9" in {
      assert(-"Scala" + -"Java" == -9)
    }
  }
}
