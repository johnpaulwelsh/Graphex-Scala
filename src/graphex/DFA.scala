package graphex

class DFA(override val states: Set[State],
          override val alphabet: Set[Char],
          override val transitions: Set[Connection],
          override val startState: State,
          override val acceptStates: Set[State])
  extends NFA(states, alphabet - Parser.EPSILON, transitions, startState, acceptStates) {

  def followTransition(from: State, input: Char): State =
    transitions.find(c => c.from == from && c.input == input) match {
      case Some(s) => s.to
      case None    => throw new StateNotFoundException("State not found in 'followTransition' function")
    }
}
