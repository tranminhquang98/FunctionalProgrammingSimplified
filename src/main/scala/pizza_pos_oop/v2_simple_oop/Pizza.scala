package pizza_pos_oop.v2_simple_oop

import pizza_pos_oop.common._

import scala.collection.mutable.ArrayBuffer

/**
 * Created by QuangTM on 20-Jun-2022.
 */
class Pizza {

  var crustSize: CrustSize = MediumCrustSize
  var crustType: CrustType = RegularCrustType

  // no need for `toppings` to be a `var`; `ArrayBuffer` is mutable
  val toppings: ArrayBuffer[Topping] = ArrayBuffer[Topping]()

  def addTopping(t: Topping): Unit = {
    toppings += t
  }

  def removeTopping(t: Topping): Unit = {
    toppings -= t
  }

  def removeAllToppings(): Unit = {
    toppings.clear()
  }

  def getPrice(
                toppingsPrices: Map[Topping, Money],
                crustSizePrices: Map[CrustSize, Money],
                crustTypePrices: Map[CrustType, Money]
              ): Money = ???

}