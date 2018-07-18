import scala.annotation.tailrec


class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
    /** Tail recursive helper function.*/
    @tailrec
    def recur(acc: List[B])(f: A => B, list: List[A]): List[B] = list match {
      // `::` is a constant time operation on lists, but it reverses the input.
      case x :: xs => recur(f(x) :: acc)(f, xs)
      case Nil => acc.reverse
    }

    recur(List())(f, list)
  }
}
