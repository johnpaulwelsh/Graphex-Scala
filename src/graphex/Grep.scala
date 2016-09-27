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

  def grep(): Unit = {
    println("yo")
  }

  def main(args: Array[String]) = {
    println("hello world")
    grep()
  }
}
