package graphex

class ProductionRegex extends Production {

  val prodBlock = new ProductionBlock
  var prodRegex: Option[ProductionRegex] = None

  if (Parser.regexCharList.nonEmpty) {
    val character = Parser.regexCharList.head
    if (character == '|') {
      Parser.regexCharList = Parser.regexCharList.tail
      prodRegex = Some(new ProductionRegex)
    }
  }

  override def createNFA: NFA = ???

  override def getNFA: NFA = ???
}
