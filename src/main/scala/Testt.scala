/**
 * Created by QuangTM on 30-Jun-2022.
 */
object Testt extends App {
  class human private(val name: String)

  object human {
    def apply(name: String): human = new human(name)
  }

  val h1 = human("Quang")
  println(h1.name)
}
