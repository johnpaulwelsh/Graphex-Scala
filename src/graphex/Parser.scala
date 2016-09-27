package graphex

import scala.io.Source

object Parser {
  var stateName = 0
  val EPSILON = 'ε'
  var nullState = Nil

  def getNextStateName: String =
    "s" + (stateName += 1)

  def learnAlphabet(filename: String): Set[Char] =
    Source.fromFile(filename).getLines.mkString.toList.toSet - '\n'


  def consolidateStars(regex: String): String =
    if (regex.contains("**")) consolidateStars(regex.replaceAll("**", "*")) else regex

  val regexCharList = consolidateStars(Grep.REGEX).toList
  val filename = Grep.FILENAME

  val alphabet = learnAlphabet(filename)
  val nfaAlphabet = alphabet + EPSILON
  val regexTree = new ProductionRegex(regexCharList)
  val nfa = regexTree.createNFA
}
