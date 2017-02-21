package d.kh.scala.byname

/**
  * Created by khamitovdm on 17/02/2017.
  */
object Math {
  def print(x: => Int): Unit = {
    try println(x) catch {
      case e: ArithmeticException =>
        println("Exception thrown:")
        e.printStackTrace()
    }
  }
}
