package d.kh.scala.conversion

/**
  * Created by khamitovdm on 22/02/2017.
  */
trait StringConverter {

  import scala.language.implicitConversions

  implicit val stringToLength = (s: String) => s.length
}
