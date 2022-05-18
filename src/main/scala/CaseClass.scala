/**
 * Created by QuangTM on 18-May-2022.
 */
object CaseClass extends App {
  case class BillingInfo(creditCards: Seq[CreditCard])

  case class Name(firstName: String, mi: String, lastName: String)

  case class User(id: Int, name: Name, billingInfo: BillingInfo, phone: String, email: String)

  case class CreditCard(name: Name, number: String, month: Int, year: Int, cvv: String)

  val hannahsName = Name(firstName = "Hannah", mi = "C", lastName = "Jones")
  // create a user
  val hannah1 = User(
    id = 1,
    name = hannahsName,
    phone = "907-555-1212",
    email = "hannah@hannahjones.com",
    billingInfo = BillingInfo(
      creditCards = Seq(
        CreditCard(
          name = hannahsName,
          number = "1111111111111111",
          month = 3,
          year = 2020,
          cvv = "123"
        )
      )
    )
  )
  println(hannah1)
  val newCCNum = hannah1.billingInfo.creditCards.head.copy(number = "1111111111111112")
  val hannah2 = hannah1.copy(billingInfo = BillingInfo(Seq(newCCNum)))
  println(hannah2)
  val newName = hannah1.name.copy(mi = "A")
  val hannah3 = hannah1.copy(name = newName)
  println(hannah3)
}
