/**
 * Created by QuangTM on 25-Apr-2022.
 */
object SumFunction extends App {
  def sum: List[Int] => Int = {
    case Nil => 0
    case x :: xs => x + sum(xs)
  }

  print(sum(List(1, 1, 2, 4, 5, 9)))
}
