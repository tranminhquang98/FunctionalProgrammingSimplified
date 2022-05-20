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

  namesStartingWithB.foreach(println)

  val oddNums = for {
    i <- 1 to 10
    x = i
    if x % 2 != 0
  } yield x
  oddNums.foreach(println)
}
