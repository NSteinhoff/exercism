object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int =
    (0 until limit)
      .filter(n => factors.exists(f => n % f == 0))
      .sum
}

