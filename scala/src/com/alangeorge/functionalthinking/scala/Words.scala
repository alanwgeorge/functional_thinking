package com.alangeorge.functionalthinking.scala

object Words extends App {
  val NON_WORDS = Set("the", "and", "of", "to", "a", "i", "it", "in", "or", "is", "d", "s", "as", "so", "but", "be")

  val r = "i love Love you and you and you"
    .split("""\s+""")
    .filter(w => !NON_WORDS.contains(w))
    .groupBy(w => w.toLowerCase)
    .map(grouped => (grouped._1, grouped._2.length))

  println(r.mkString(" "))
}
