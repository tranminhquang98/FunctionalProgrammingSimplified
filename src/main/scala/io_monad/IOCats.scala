package io_monad

/**
 * Created by QuangTM on 02-Jun-2022.
 */

import cats.effect.{IO => Io}

object IOCats extends App {
  val program: Io[Unit] = for {
    _ <- Io {
      println("Welcome to Scala! What's your name?")
    }
    name <- Io {
      scala.io.StdIn.readLine
    }
    nameUC = name.toUpperCase
    _ <- Io {
      println(s"Well hello, $nameUC!")
    }
  } yield ()
  // ...
  // ...
  // some time later ...
  // ...
  // ...
  program.unsafeRunSync()
}
