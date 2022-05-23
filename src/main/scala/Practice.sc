def multiplyBy: Int => Int => Int = a => b => a * b
val multiplyBy10: Int => Int = multiplyBy(10)(_)
val list = 1 :: 2 :: 3 :: Nil
println(multiplyBy10(5))
/** ******************************* */
import scala.annotation.tailrec

def sum(list: List[Int]): Int = {
  @tailrec
  def sumFunction(list: List[Int], acc: Int): Int = list match {
    case Nil => acc
    case x :: xs => sumFunction(xs, x + acc)
  }

  sumFunction(list, 0)
}
//println(sum(1 to 10000 toList))

/** ******************************* */
case class a(name: String, age: Int)

val aa = a("q", 3)
aa match {
  case a(n, a) => println(n, a)
}
/** ******************************* */
val foo = "foo".map(List(_)).flatten
val cc = List(foo: _*)
val foo2 = "foo".split("").toList
/** ******************************* */
def returnIntandString(): (Int, String) = {
  (5, "c")
}
val (res1: Int, res2: String) = returnIntandString()

/** ******************************* */
