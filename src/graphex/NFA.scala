package graphex

object NFA {
  def main(args: Array[String]) {
    val dingo = new Connection(new NFAState("yo"), 'c', new NFAState("hi"))
    println(dingo)
  }
}
