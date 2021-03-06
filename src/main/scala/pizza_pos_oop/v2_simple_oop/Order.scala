package pizza_pos_oop.v2_simple_oop

import scala.collection.mutable.ArrayBuffer

/**
 * Created by QuangTM on 20-Jun-2022.
 */
class Order {

  // an order contains a list of pizzas
  val pizzas: ArrayBuffer[Pizza] = ArrayBuffer[Pizza]()

  // could be a constructor parameter *if* you always create
  // a customer before creating an order
  var customer: Option[Customer] = None

  def addPizzaToOrder(p: Pizza): Unit = {
    pizzas += p
  }

  def removePizzaFromOrder(p: Pizza): Unit = {
    pizzas -= p
  }

  // TODO
  //def calculateOrderPrice(): Money = ???
  def getBasePrice(): Money = ???

  def getTaxes(): Money = ???

  def getTotalPrice(): Money = ???

}
