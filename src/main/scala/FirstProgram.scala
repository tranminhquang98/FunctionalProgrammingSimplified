/**
 * Created by QuangTM on 05-Feb-2022.
 */
object FirstProgram extends App {
  println("Hello, World!")

  def double: Int => Int = _ * 2

  def factorial: (Long, Long) => Long = (n, acc) =>
    if (n == 1 || n == 0) acc
    else factorial(n - 1, n * acc)
}
