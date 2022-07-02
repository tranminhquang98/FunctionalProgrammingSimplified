package FPConcurrencyAndMutability.test1

/**
 * Created by QuangTM on 24-Jun-2022.
 */
object SimpleBadConcurrency extends App {

  val me = new Person("Alvin", "Talkeetna", "Alaska")

  val t1 = new Thread {
    override def run {
      Thread.sleep(1000)
      me.town = "Boulder"
      Thread.sleep(3000)
      me.state = "Colorado"
    }
  }

  // start the thread
  t1.start

  println(s"1) $me")

  Thread.sleep(2000)
  println(s"2) $me")

  Thread.sleep(2000)
  println(s"3) $me")

}
