package graphex

class Connection(val from: State,
                 val input: Char,
                 val to: State) {
  override val toString = s"$from -> $to label='$input'"
}
