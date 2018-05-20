import scala.collection.immutable.{TreeMap, SortedMap}


class School {
  type DB = SortedMap[Int, Seq[String]]

  def add(name: String, g: Int) = {
    db = db.updated(g, db.getOrElse(g, Seq()) :+ name)
  }

  var db: DB = TreeMap[Int, Seq[String]]()

  def grade(g: Int): Seq[String] = db.getOrElse(g, Seq())

  def sorted: DB = db.mapValues(_.sorted)
}
