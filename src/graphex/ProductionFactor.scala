package graphex

class ProductionFactor extends Production {

  var prodBase: ProductionBase = new ProductionBase
  var hasStar = false

  if (Parser.regexCharList.nonEmpty) {
    val character = Parser.regexCharList.head
    if (character == '*') {
      hasStar = true
      Parser.regexCharList = Parser.regexCharList.tail
    }
  }

  override def createNFA: NFA = ???

  override def getNFA: NFA = ???
}
