package graphex

import scala.io.Source

object Parser {
  var stateName = 0
  val EPSILON = 'ε'
  val nullState = new NFAState("null")

  def getNextStateName: String =
    "s" + (Parser.stateName += 1)

  def learnAlphabet(filename: String): Set[Char] =
    Source.fromFile(filename).getLines.mkString.toList.toSet - '\n'

  def consolidateStars(regex: String): String =
    if (regex.contains("**")) consolidateStars(regex.replaceAll("**", "*")) else regex

  var regexCharList: List[Char] = consolidateStars(Grep.REGEX).toList

  val alphabet: Set[Char] = learnAlphabet(Grep.FILENAME)
  val nfaAlphabet: Set[Char] = alphabet + EPSILON
  val regexTree = new ProductionRegex
  val nfa: NFA = regexTree.createNFA
}
