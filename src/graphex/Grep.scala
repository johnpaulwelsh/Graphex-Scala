package graphex

object Grep {
  var REGEX = ""
  var FILENAME = ""

  def makeGraphViz(nfa: NFA, outputFile: String): Unit = {
    val gv = new GraphViz()
    gv.addln(gv.start_graph())

    gv.addln("rankdir=LR;")

    gv.addln("node [shape = none]; \"\";")

    // Add which states will be accept states
    var acceptStates = nfa.acceptStates.map(_.getName).mkString(", ")
    acceptStates = acceptStates.substring(0, acceptStates.length - 2) + ";"
    gv.addln("node [shape = doublecircle]; " + acceptStates)

    gv.addln("node [shape = circle];")

    // Add the start state
    gv.addln("\"\" ->" + nfa.startState.getName + ";")

    // Add all the other transitions
    for (c <- nfa.transitions) gv.addln(c + ";")

    gv.addln(gv.end_graph())

    GraphViz.WriteGraphSource(gv, outputFile)
  }

  def grep(isDFA: Boolean, outputFile: String, regex: String, file: String): Unit = {
    println("yo1")
  }

  def grep(nfaFile: String, dfaFile: String, regex: String, file: String): Unit = {
    println("yo2")
  }

  def grep(regex: String, file: String): Unit = {
    REGEX = regex
    FILENAME = file
    def nfa = parseAndRetrieveNFA
    println(nfa)
  }

  def parseAndRetrieveNFA: NFA = Parser.nfa

  def main(args: Array[String]): Unit = {
    if (args(0) == "-n") {
      if (args(2) == "-d")      grep(args(1), args(3), args(4), args(5))
      else                      grep(false,   args(1), args(2), args(3))

    } else if (args(0) == "-d") grep(true,    args(1), args(2), args(3))
    else                        grep(args(0), args(1))
  }
}
