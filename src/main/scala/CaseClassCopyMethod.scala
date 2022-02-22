/**
 * Created by QuangTM on 19-Feb-2022.
 */
object CaseClassCopyMethod extends App {
  val p1 = Person("a", 10)
  val p2 = p1.copy("b")

  case class Person(name: String, age: Int)

  println(p1)
  println(p2)
}
