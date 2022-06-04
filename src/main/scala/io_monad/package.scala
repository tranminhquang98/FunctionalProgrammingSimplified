/**
 * Created by QuangTM on 28-May-2022.
 */
package object io_monad {
  def getLine: IO[String] = IO(scala.io.StdIn.readLine())

  def putStrLn(s: String): IO[Unit] = IO(println(s))
}
