package state_manually

/**
 * Created by QuangTM on 02-Jun-2022.
 */
object Golfing2 extends App {

  case class GolfState(strokes: List[Int])

  // take the old state, and an increment to that state
  def nextStroke(s: GolfState, distanceOfNextHit: Int): GolfState = {
    GolfState(distanceOfNextHit :: s.strokes)
  }

  val state0 = GolfState(Nil)
  val state1 = nextStroke(state0, 20)
  val state2 = nextStroke(state1, 15)
  val state3 = nextStroke(state2, 0)

  println(state3)
  println(state2)
}
