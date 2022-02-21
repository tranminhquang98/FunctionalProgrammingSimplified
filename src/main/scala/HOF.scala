/**
 * Created by QuangTM on 21-Feb-2022.
 */
object HOF extends App {
  val sayHello2: (() => Unit) => Unit = f => f()
  val helloQuang2: () => Unit = () => println("Hello, Quang2")

  sayHello(helloQuang)

  def sayHello(callback: () => Unit): Unit = callback()

  def helloQuang(): Unit = println("Hello, Quang")

  sayHello2(helloQuang2)
}
