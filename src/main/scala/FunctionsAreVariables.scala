import scala.language.postfixOps

/**
 * Created by QuangTM on 21-Feb-2022.
 */
object FunctionsAreVariables extends App {
  lazy val double: Int => Int = _ * 2
  lazy val triple: Int => Int = _ * 3

  lazy val function = Map(
    "2x" -> double,
    "3x" -> triple
  )

  println(1 to 10 map double toList)
  println(function("2x")(5))
  println(function("3x")(4))

  case class Person(firstName: String, lastName: String)

  val fullName: Person => String = p => s"${p.firstName} ${p.lastName}"
  val Q = Person("Quang", "Tran")
  println(fullName(Q))

  val plus1Fn = plus1 _

  def plus1(x: Int): Int = x + 1

  println(plus1Fn(1))
}
