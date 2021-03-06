package state_manually

/**
 * Created by QuangTM on 02-Jun-2022.
 */
object Golfing1 extends App {

  case class GolfState(distance: Int)

  def nextStroke(s: GolfState, distanceOfNextHit: Int): GolfState = {
    GolfState(s.distance + distanceOfNextHit)
  }

  val state1 = GolfState(20)
  val state2 = nextStroke(state1, 15)
  val state3 = nextStroke(state2, 0)

  println(state3)

}
