package graphex

trait State

class NFAState(name: String) extends State { override val toString = name }

class DFAState(name: String, substates: Set[State]) extends NFAState(name)
