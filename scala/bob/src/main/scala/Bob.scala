object Bob {
  def response(statement: String): String = {
    val s = statement.trim
    val letters = s.filter(_.isLetter)

    if (s.isEmpty) {
      "Fine. Be that way!"
    } else if (!letters.isEmpty && letters.forall(_.isUpper)) {
      "Whoa, chill out!"
    } else if (s.endsWith("?")) {
      "Sure."
    } else {
      "Whatever."
    }
  }
}
