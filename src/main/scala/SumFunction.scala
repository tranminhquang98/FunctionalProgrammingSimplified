import scala.annotation.tailrec
import scala.language.postfixOps

/**
 * Created by QuangTM on 25-Apr-2022.
 */
object SumFunction extends App {
  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: xs => x + sum(xs)
  }

  @tailrec
  private def sumWithAccumulator(list: List[Int], accumulator: Int): Int =
    list match {
      case Nil => accumulator
      case x :: xs => sumWithAccumulator(xs, accumulator + x)
    }

  println(sumWithAccumulator(1 to 10000 toList, 0))
}
