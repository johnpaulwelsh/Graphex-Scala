package graphex

class Connection(from: State, input: Char, to: State) { override val toString = s"$from -> $to label='$input'" }
