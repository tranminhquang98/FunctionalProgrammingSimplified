/**
 * Created by QuangTM on 22-Feb-2022.
 */
object ByNameParameter extends App {
  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    (result, delta / 1000000d)
  }

  def timer2[A]: (=> A) => (A, Double) = blockOfCode => {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    (result, delta / 1000000d)
  }

  println(timer2(println("hello world")))
}
