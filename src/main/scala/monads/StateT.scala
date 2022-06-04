package monads

import scala.language.higherKinds

/**
 * Created by QuangTM on 04-Jun-2022.
 */
case class StateT[M[_], S, A](run: S => M[(S, A)]) {
  def flatMap[B](g: A => StateT[M, S, B])(implicit M: Monad[M]): StateT[M, S, B] = StateT { (s0: S) =>
    M.flatMap(run(s0)) {
      case (s1, a) => g(a).run(s1)
    }
  }

  def map[B](f: A => B)(implicit M: Monad[M]): StateT[M, S, B] = flatMap(a => StateT.point(f(a)))
}

object StateT {
  def point[M[_], S, A](v: A)(implicit M: Monad[M]): StateT[M, S, A] = StateT(run = s => M.lift((s, v)))
}

