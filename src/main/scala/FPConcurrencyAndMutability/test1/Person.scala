package FPConcurrencyAndMutability.test1

/**
 * Created by QuangTM on 24-Jun-2022.
 */
class Person(
              var name: String,
              var town: String,
              var state: String
            ) {
  override def toString = s"name: $name, town: $town, state: $state"
}