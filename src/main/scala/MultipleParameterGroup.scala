/**
 * Created by QuangTM on 25-Feb-2022.
 */
object MultipleParameterGroup extends App {
  var i = 0

  def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit = {
    while (testCondition) {
      codeBlock
    }
  }

  whilst(i < 5) {
    println(i)
    i += 1
  }

  /*
  A method or constructor can have only one implicit parameter list, and it must
  be the last parameter list given

  If there are several eligible arguments which match the implicit parameter’s
  type, a most specific one will be chosen using the rules of static overloading
  resolution
   */

  implicit val boo: Boolean = true

  def printIfTrue(a: Int)(implicit boo: Boolean): Unit = if (boo) println(a)

  printIfTrue(5)
}
