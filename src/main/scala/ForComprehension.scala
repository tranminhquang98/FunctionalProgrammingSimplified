import scala.collection.mutable.ArrayBuffer

/**
 * Created by QuangTM on 18-May-2022.
 */
object ForComprehension extends App {
  case class Person(firstName: String, lastName: String)

  val people = List(
    Person("barney", "rubble"),
    Person("fred", "flintstone")
  )
  val namesStartingWithB = for {
    p <- people // generator
    fname = p.firstName // definition
    if fname startsWith "b" // filter
  } yield fname.toUpperCase

  case class Sequence[A](initialElems: A*) {
    private val elems = ArrayBuffer[A]()
    elems ++= initialElems

    def foreach(block: A => Unit): Unit = elems.foreach(block)

    def map[B](f: A => B): Sequence[B] = Sequence(elems.map(f): _*)

    def flatMap[B](f: A => Sequence[B]): Sequence[B] = {
      val mapRes: Sequence[Sequence[B]] = map(f) //map
      flattenLike(mapRes) //flatten
    }

    def withFilter(p: A => Boolean): Sequence[A] = Sequence(elems.filter(p): _*)

    def flattenLike[B](seqOfSeq: Sequence[Sequence[B]]): Sequence[B] = {
      val xs = ArrayBuffer[B]()
      for (listB: Sequence[B] <- seqOfSeq) {
        for (e <- listB) {
          xs += e
        }
      }
      Sequence(xs: _*)
    }
  }

  case class Person2(name: String)
  val myFriends = Sequence(
    Person2("Adam"),
    Person2("David"),
    Person2("Frank")
  )
  val adamsFriends = Sequence(
    Person2("Nick"),
    Person2("David"),
    Person2("Frank")
  )

  val mutualFriends = for {
    myFriend <- myFriends // generator
    adamsFriend <- adamsFriends // generator
    if myFriend.name == adamsFriend.name
  } yield myFriend
  mutualFriends.foreach(println)
}
