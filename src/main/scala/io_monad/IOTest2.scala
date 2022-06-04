package io_monad

/**
 * Created by QuangTM on 28-May-2022.
 */
object IOTest2 extends App {
  def forExpression: IO[Unit] = for {
    _ <- putStrLn("First name?")
    firstName <- getLine
    _ <- putStrLn(s"Last name?")
    lastName <- getLine
    fNameUC = firstName.toUpperCase
    lNameUC = lastName.toUpperCase
    _ <- putStrLn(s"First: $fNameUC, Last: $lNameUC")
  } yield ()

  forExpression.run
}
