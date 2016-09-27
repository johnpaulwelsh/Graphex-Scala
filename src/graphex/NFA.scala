package graphex

class NFA(val states: Set[State],
          val alphabet: Set[Char] = Parser.nfaAlphabet,
          val transitions: Set[Connection],
          val startState: State,
          val acceptStates: Set[State]) {
  override def toString = s"$startState.name --> ... --> $acceptStates"
}
