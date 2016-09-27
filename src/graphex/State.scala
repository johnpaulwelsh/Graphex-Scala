package graphex

abstract class State {
  def getName: String
  def getSubstates: Option[Set[State]]
}
