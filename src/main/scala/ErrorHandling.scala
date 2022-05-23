import scala.util.{Failure, Success, Try}

/**
 * Created by QuangTM on 21-May-2022.
 */
object ErrorHandling extends App {
  // 1. Option
  // Option don’t tell you anything about why something failed. For
  // example, a consumer of the makeInt function can’t tell why a String wasn’t
  // converted to an Int, it only knows that it got a None in return
  // ****** Use for handling null values ******
  def makeInt(s: String): Option[Int] =
    try Some(s.trim.toInt)
    catch {
      case _: Exception => None
    }

  makeInt(" alo ") match {
    case Some(i) => println(s"i is $i")
    case None => println("i is unparseable")
  }

  val res = for {
    x <- makeInt("1")
    y <- makeInt("2")
  } yield x + y
  println(res)

  // 2. Try
  // The benefit of Try over Option is that when the enclosed code throws an exception,
  // Try returns a Failure object that contains the exception information
  def makeInt2(s: String): Try[Int] = Try(s.trim.toInt)

  makeInt2("f") match {
    case Success(value) => println(s"i is $value")
    case Failure(exception) => println(exception)
  }

  val res2 = for {
    x <- makeInt2("1")
    y <- makeInt2("2")
  } yield x + y
  println(res2)
}
