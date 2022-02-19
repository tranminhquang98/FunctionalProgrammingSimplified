/**
 * Created by QuangTM on 19-Feb-2022.
 */
object CaseClassCopyMethod extends App {
  case class Person(name: String, age: Int)

  val p1 = Person("a", 10)
  val p2 = p1.copy("b")
  println(p1)
  println(p2)
}
