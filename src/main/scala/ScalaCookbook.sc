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

case class a(name: String, age: Int)

val aa = a("q", 3)
aa match {
  case a(n, a) => println(n, a)
}
