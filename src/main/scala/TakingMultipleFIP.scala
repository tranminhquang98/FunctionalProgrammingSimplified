import scala.language.postfixOps

/**
 * Created by QuangTM on 22-Feb-2022.
 */
object TakingMultipleFIP extends App {
  def returnTupleFrom2FIP: ((Int, Int) => Int, (Int, Int) => Int, Int, Int) => (Int, Int) =
    (f1, f2, n1, n2) => (f1(n1, n2), f2(n1, n2))

  def add2Num: (Int, Int) => Int = _ + _

  def multiply2Num: (Int, Int) => Int = _ * _

  println(returnTupleFrom2FIP(add2Num, multiply2Num, 2, 3))

  def map[A, B]: (A => B, Seq[A]) => Seq[B] = (f, list) =>
    for (x <- list) yield f(x)

  def plus1: Int => Int = _ + 1

  def plusS: Char => String = s => s"${s}2"

  //  println(map(plus1, 1 to 10))
  println(map(plusS, 'a' to 'd'))

  def filter[A]: (A => Boolean, Seq[A]) => Seq[A] = (f, list) =>
    for (x <- list if f(x)) yield x

  def isEven: Int => Boolean = _ % 2 == 0

  println(filter(isEven, 1 to 10))
}
