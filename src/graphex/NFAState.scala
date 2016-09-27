package graphex

class NFAState(val name: String) extends State {
  override def getName: String = name
  override def getSubstates: Option[Set[State]] = None
}
