package graphex

class ProductionBase() extends Production {

  var character: Char = '\u0000'
  var prodRegex: Option[ProductionRegex] = None

  if (Parser.regexCharList.nonEmpty) {
    val next = Parser.regexCharList.head

    next match {
      case '(' =>
        character = Parser.EPSILON
        Parser.regexCharList = Parser.regexCharList.tail
        prodRegex = Some(new ProductionRegex)

      case ')' =>
        character = Parser.EPSILON
        Parser.regexCharList = Parser.regexCharList.tail

      case _ =>
        character = next
        Parser.regexCharList = Parser.regexCharList.tail
    }
  }

  override def createNFA: NFA = ???

  override def getNFA: NFA = ???
}
