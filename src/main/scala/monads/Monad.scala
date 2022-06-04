package monads

import scala.language.higherKinds

/**
 * Created by QuangTM on 04-Jun-2022.
 */
trait Monad[M[_]] {

  // FP’ers prefer to call this `point`
  def lift[A](a: => A): M[A]

  def flatMap[A, B](ma: M[A])(f: A => M[B]): M[B]

  def map[A, B](ma: M[A])(f: A => B): M[B] = flatMap(ma)(a => lift[B](f(a)))
}
