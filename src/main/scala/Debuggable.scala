/**
 * Created by QuangTM on 24-May-2022.
 */
object Debuggable extends App {
  //  case class Debuggable[A](value: A, message: String) {
  //    def map[B](f: A => B): Debuggable[B] = {
  //      val nextValue = f(value)
  //      Debuggable(nextValue, message)
  //    }
  //
  //    def flatMap[B](f: A => Debuggable[B]): Debuggable[B] = {
  //      val nextValue = f(value)
  //      Debuggable(nextValue.value, message + nextValue.message)
  //    }
  //  }
  case class Debuggable[A](value: A, log: List[String]) {
    def map[B](f: A => B): Debuggable[B] = {
      val nextValue = f(value)
      Debuggable(nextValue, this.log)
    }

    // prepend `this.log` before `nextValue.log`
    def flatMap[B](f: A => Debuggable[B]): Debuggable[B] = {
      val nextValue: Debuggable[B] = f(value)
      Debuggable(nextValue.value, this.log ::: nextValue.log)
    }
  }

  //  def f(a: Int): Debuggable[Int] = {
  //    val result = a * 2
  //    Debuggable(result, s"f: multiply $a * 2 = $result\n")
  //  }
  //
  //  def g(a: Int): Debuggable[Int] = {
  //    val result = a * 3
  //    Debuggable(result, s"g: multiply $a * 3 = $result\n")
  //  }
  //
  //  def h(a: Int): Debuggable[Int] = {
  //    val result = a * 4
  //    Debuggable(result, s"h: multiply $a * 4 = $result\n")
  //  }
  //
  //  val finalResult = for {
  //    fRes <- f(100)
  //    gRes <- g(fRes)
  //    hRes <- h(gRes)
  //  } yield s"result: $hRes"
  //  println(finalResult.message)
  //  println(s"Output is ${finalResult.value}")
  def f(a: Int): Debuggable[Int] = {
    val result = a * 2
    Debuggable(result, List(s"f: multiply $a * 2 = $result"))
  }

  def g(a: Int): Debuggable[Int] = {
    val result = a * 3
    Debuggable(result, List(s"g: multiply $a * 3 = $result"))
  }

  def h(a: Int): Debuggable[Int] = {
    val result = a * 4
    Debuggable(result, List(s"h: multiply $a * 4 = $result"))
  }

  val finalResult = for {
    fRes <- f(100)
    gRes <- g(fRes)
    hRes <- h(gRes)
  } yield s"result: $hRes"
  finalResult.log.foreach(l => println(s"LOG: $l"))
  println(s"Output is ${finalResult.value}")
}
