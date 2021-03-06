package v2_loop_without_quit

import monads.{IO, Monad, StateT}

/**
 * Created by QuangTM on 04-Jun-2022.
 */
object LoopWithoutQuitLotsOfDebug extends App {

  // the `IO` functions i used previously
  def getLine: IO[String] = IO {
    val in = scala.io.StdIn.readLine()
    //println(s"getLine: in = |$in|")
    in
  }

  def putStr(s: String): IO[Unit] = IO {
    //println(s"putStr: s = |$s|")
    print(s)
  }

  def toInt(s: String): Int = {
    //println(s"toInt: s = $s")
    try {
      s.toInt
    } catch {
      case _: NumberFormatException => 0
    }
  }

  // a class to track the sum of the ints that are given
  case class SumState(sum: Int)

  // an implementation of the `Monad` trait for the `IO` type
  implicit val IOMonad: Monad[IO] = new Monad[IO] {
    def lift[A](a: => A): IO[A] = {
      // only see this output when the loop exits properly
      //println(s"IOMonad::point received 'a': $a")
      IO(a)
    }

    def flatMap[A, B](ma: IO[A])(f: A => IO[B]): IO[B] = ma.flatMap(f)
  }

  /**
   * given the int `i`, add it to the previous `sum` from the given SumState `s`;
   * then return a new state `newState`, created with the new sum;
   * at the end of the function, wrap `newState` in an `IO`;
   * the anonymous function creates a `StateT` wrapped around that `IO`.
   */
  def doSumWithStateT(newValue: Int): StateT[IO, SumState, Int] = StateT { (oldState: SumState) =>

    // create a new sum from `i` and the previous sum from `s`
    val newSum = newValue + oldState.sum
    println(s"updateIntState, old sum:   " + oldState.sum)
    println(s"updateIntState, new input: " + newValue)
    println(s"updateIntState, new sum:   " + newSum)

    // create a new SumState
    val newState: SumState = oldState.copy(sum = newSum)

    // return the new state and the new sum, wrapped in an IO
    IO(newState, newSum)
  }

  /**
   * the purpose of this function is to “lift” an IO action into the StateT monad.
   * given an IO instance named `io` as input, the anonymous function transforms
   * the `IO[A]` into an `IO[(SumState, A)]`;
   * that result is then wrapped in a `StateT`.
   */
  def liftIoIntoStateT[A](io: IO[A]): StateT[IO, SumState, A] = StateT { s: SumState =>

    // transform `IO[A]` into `IO(SumState, A)`
    val result: IO[(SumState, A)] = io.map(a => (s, a))

    // debug: use this as a way to see what's going on here. if you enter 1 and then 2
    // you'll see the output, `(SumState(1), 2)`.
    //result.map(tup => println(s"lift: (${tup._1}, ${tup._2})"))

    // yield the result of this anonymous function (which will be wrapped by StateT)
    result
  }

  // new versions of the i/o functions that uses StateT
  def getLineAsStateT: StateT[IO, SumState, String] = liftIoIntoStateT(getLine)

  def putStrAsStateT(s: String): StateT[IO, SumState, Unit] = liftIoIntoStateT(putStr(s))

  /**
   * you have to kill this loop manually (i.e., CTRL-C)
   */
  def sumLoop: StateT[IO, SumState, Unit] = for {
    _ <- putStrAsStateT("\ngive me an int: ")
    input <- getLineAsStateT
    i <- liftIoIntoStateT(IO(toInt(input)))
    _ <- doSumWithStateT(i)
    _ <- sumLoop
  } yield Unit

  val result: (SumState, Unit) = sumLoop.run(SumState(0)).run

  // this line won't be reached because you have to kill the loop manually
  println(s"Final SumState: ${result._1}")

}
