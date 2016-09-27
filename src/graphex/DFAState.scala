package graphex

class DFAState(override val name: String, val substates: Set[State]) extends NFAState(name) {
  override def getSubstates: Option[Set[State]] = Some(substates)
}
