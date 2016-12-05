package graphex

class ProductionBlock extends Production {

  val prodFactor = new ProductionFactor
  var prodBlock: Option[ProductionBlock] = None

  if (Parser.regexCharList.nonEmpty) {
    val character = Parser.regexCharList.head
    if (character != '*' && character != '|')
      prodBlock = Some(new ProductionBlock())
  }

  override def createNFA: NFA = ???

  override def getNFA: NFA = ???
}
