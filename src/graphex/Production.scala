package graphex

trait Production {
  def createNFA: NFA
  def getNFA: NFA
}
