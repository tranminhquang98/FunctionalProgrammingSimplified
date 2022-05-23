import scala.annotation.tailrec
import scala.language.postfixOps

/**
 * Created by QuangTM on 25-Apr-2022.
 */
object SumFunction extends App {
  def sum(list: List[Int]): Int = {
    @tailrec
    def sumWithAccumulator(list: List[Int], accumulator: Int): Int = list match {
      case Nil => accumulator
      case x :: xs => sumWithAccumulator(xs, accumulator + x)
    }

    sumWithAccumulator(list, 0)
  }

  println(sum(1 to 10000 toList))
}
/*
1. Keep the original function signature the same (i.e., sum’s signature).
2. Create a second function by (a) copying the original function, (b) giving it a
new name, (c) giving it a new “accumulator” input parameter, and (d) adding the @tailrec annotation to it.
3. Modify the second function’s algorithm so it uses the new accumulator.
4. Call the second function from inside the first function. When you do this you
give the second function’s accumulator parameter a “seed” value
 */