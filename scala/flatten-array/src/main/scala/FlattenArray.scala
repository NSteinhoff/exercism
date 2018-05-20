object FlattenArray {
    def flatten(list: List[Any]): List[Any] = for {
      x <- list
      if x != null
      y <- x match {
        case xs: List[Any] => flatten(xs)
        case x => List(x)
      }
    } yield y
}
