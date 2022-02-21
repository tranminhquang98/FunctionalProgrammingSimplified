/**
 * Created by QuangTM on 21-Feb-2022.
 */
object HOF extends App {
  def sayHello(callback: () => Unit): Unit = callback()

  def helloQuang(): Unit = println("Hello, Quang")

  sayHello(helloQuang)

  val sayHello2: (() => Unit) => Unit = f => f()
  val helloQuang2: () => Unit = () => println("Hello, Quang2")

  sayHello2(helloQuang2)
}
