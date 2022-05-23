/**
 * Created by QuangTM on 22-May-2022.
 */
object WrapperClass extends App {
  class Wrapper[A] private(value: A) {
    def map[B](f: A => B): Wrapper[B] = {
      val newValue = f(value)
      new Wrapper(newValue)
    }

    def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = {
      val newValue = f(value)
      newValue
    }

    override def toString: String = value.toString
  }

  object Wrapper {
    def apply[A](value: A): Wrapper[A] = new Wrapper(value)
  }

  val result: Wrapper[Int] = for {
    a <- Wrapper(1)
    b <- Wrapper(2)
    c <- Wrapper(3)
  } yield a + b + c

  println(result)
}
