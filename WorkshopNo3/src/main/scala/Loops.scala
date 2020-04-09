import scala.io.StdIn
import scala.collection.immutable.ListMap

object Loops {

  def main(args: Array[String]): Unit = {

    println("Loop 1")
    // to - włącznie z warunkiem krawędziowym
    for (i <- 1 to 10) {
      println(i)
    }

    println("\n\n\nLoop 2")
    // until - wyłączenie warunku krawędziowego
    for (i <- 1 until 10) {
      println(i)
    }

    println("\n\n\nLoop 3")
    // zagnieżdzenie wersja 1
    for (i <- 1 until 10; j <- 1 until 10) {
      for (i <- 1 until 10; j <- 1 until 10) {
        println("i=" + i + ", j=" + j)
      }
    }

    println("\n\n\nLoop 4")
    // zagnieżdzenie wersja 2
    for (i <- 1 until 10; j <- 1 until 10) {
      println("i=" + i + ", j=" + j)
    }

    var typed = 0
    var typed2 = 0

    println("\n\n\nLoop 5")
    // pętla do-while
    do {
      println("Guess the lucky number !:\n")
      typed = StdIn.readInt()
    } while (typed != 7)

    // pętla do-while
    println("\n\n\nLoop 6")
    while (typed != 13) {
      println("Guess the unlucky number !:\n")
      typed = StdIn.readInt()
    }

    // Iterowanie po kolekcjach

    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("\n\n\nLoop 7")
    for (item <- list) {
      println(item)
    }

    val map = ListMap((1, 'A'), (2, 'B'), (3, 'C'), (4, 'D'), (5, 'E'), (6, 'F'))
    println("\n\n\nLoop 8")

    for ((key, value) <- map) {
      println("Key=" + key + ", value=" + value)
    }

    println("\n\n\nLoop 9")
    for (item <- list if item % 2 != 0; if item > 3) {
      println(item)
    }

    println("\n\n\nLoop 10")
    val items = for (item <- list if item % 2 != 0; if item > 3)
      yield item

    println(items.mkString(" , "))
    assert(items.size == 3)
    assert(items.sameElements(List(5, 7, 9)))

    println("\n\n\nLoop 11")
    // pętla funkcyjna foreach
    var word = new StringBuilder
    var factorial = 1: Int

    map.foreach(pair => (word += pair._2, factorial *= pair._1, println("Key=" + pair._1 + ", Value=" + pair._2)))
    println("Word=" + word.toString + ", Factorial=" + factorial)

    println("\n\n\nLoop 12")
    // pętla funkcyjna map
    val listDecreasedValues = list.map(item => item - 5)
    listDecreasedValues.foreach(println(_))


    val r1 = 1 to 10
    val r2 = 1 until 10
    val r3 = Range(0, 21, 3)

    println("\n\n\nRange to")
    // range 'to'
    r1.foreach(println(_))
    println("\n\n\nRange until")
    // range 'until'
    r2.foreach(println(_))
    println("\n\n\nRange object")
    // range 'Range'
    r3.foreach(println(_))
}
}
