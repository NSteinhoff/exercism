import scala.annotation.tailrec


class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
    /** Tail recursive helper function.*/
    @tailrec
    def recur(acc: List[B])(list: List[A], f: A => B): List[B] = list match {
      // `::` is a constant time operation on lists, but it reverses the input.
      case x :: xs => recur(f(x) :: acc)(xs, f)
      case Nil => acc.reverse
    }

    recur(List())(list, f)
  }
}
