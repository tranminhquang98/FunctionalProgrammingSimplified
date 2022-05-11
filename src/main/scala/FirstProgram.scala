import scala.annotation.tailrec

/**
 * Created by QuangTM on 05-Feb-2022.
 */
object FirstProgram extends App {
  println("Hello, World!")

  def double: Int => Int = _ * 2

  def isEven: Int => Boolean = _ % 2 == 0

  @tailrec
  def factorial(n: Int, acc: Int): Int =
    if (n == 1 || n == 0) acc
    else factorial(n - 1, n * acc)
}
