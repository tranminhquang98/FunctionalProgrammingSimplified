import scala.language.postfixOps

/**
 * Created by QuangTM on 21-Feb-2022.
 */
object FunctionsAreVariables extends App {
  val Q = Person("Quang", "Tran")
  val plus1Fn = plus1 _

  def function = Map(
    "2x" -> double,
    "3x" -> triple
  )

  def triple: Int => Int = _ * 3

  def double: Int => Int = _ * 2

  println(1 to 10 map double toList)
  println(function("2x")(5))
  println(function("3x")(4))

  def fullName: Person => String = p => s"${p.firstName} ${p.lastName}"

  def plus1(x: Int): Int = x + 1

  println(fullName(Q))

  case class Person(firstName: String, lastName: String)

  println(plus1Fn(1))
}
