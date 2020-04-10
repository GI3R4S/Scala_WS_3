import scala.io.StdIn
import scala.collection.immutable.ListMap

object Loops {

  def main(args: Array[String]): Unit = {
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    val range1 = 1 to 10 // 1,2, ..., 9, 10
    val range2 = 1 until 10 // 1,2, ..., 8, 9
    val range3 = Range(0, 21, 3) // 0, 3 ..., 15, 18

    println("\n\n\nRange to")
    // range 'to'
    range1.foreach(println(_))
    println("\n\n\nRange until")
    // range 'until'
    range2.foreach(println(_))
    println("\n\n\nRange object")
    // range 'Range'
    range3.foreach(println(_))
    
    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("Loop 1")
    // słowo kluczowe 'to' - włącznie z warunkiem krawędziowym
    for (i <- 1 to 10) {
      println(i)
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("\n\n\nLoop 2")
    // słowo kluczowe 'until' - wyłączenie warunku krawędziowego
    for (i <- 1 until 10) {
      println(i)
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("\n\n\nLoop 3")
    // zagnieżdzenie pętli 'for' wersja 1
    for (i <- 0 until 3) {
      for (j <- 0 until 3) {
        println("i=" + i + ", j=" + j)
      }
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("\n\n\nLoop 4")
    // zagnieżdzenie wersja 2
    for (i <- 0 until 3; j <- 0 until 3) {
      println("i=" + i + ", j=" + j)
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("\n\n\nLoop 5")
    // pętla 'do-while'
    var typed = 0
    do {
      println("Guess the lucky number !:\n")
      typed = StdIn.readInt()
    } while (typed != 7)

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("\n\n\nLoop 6")
    // pętla 'while'
    var typed2 = 0
    while (typed2 != 13) {
      println("Guess the unlucky number !:\n")
      typed = StdIn.readInt()
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    // Iterowanie po kolekcjach z pojedynczymi elementami
    println("\n\n\nLoop 7")
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    for (item <- list) {
      println(item)
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    // Iterowanie po mapie ze złożonymi elementami
    println("\n\n\nLoop 8")
    val map = ListMap((1, 'A'), (2, 'B'), (3, 'C'), (4, 'D'), (5, 'E'), (6, 'F'))

    for ((key, value) <- map) {
      println("Key=" + key + ", value=" + value)
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    // Iterowanie po liście z narzuceniem warunków co do elementów
    println("\n\n\nLoop 9")

    for (item <- list if item % 2 != 0; if item > 3) {
      println(item)
    }

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    // Iterowanie po liście w celu filtracji i utworzenia nowej listy
    println("\n\n\nLoop 10")

    val items = for (item <- list if item % 2 != 0; if item > 3)
      yield item

    println(items.mkString(" , "))
    assert(items.size == 3)
    assert(items.sameElements(List(5, 7, 9)))

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("\n\n\nLoop 11")
    // pętla funkcyjna 'foreach'
    var word = new StringBuilder
    var factorial = 1: Int

    map.foreach(pair => (word += pair._2, factorial *= pair._1, println("Key=" + pair._1 + ", Value=" + pair._2)))
    println("Word=" + word.toString + ", Factorial=" + factorial)

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////

    println("\n\n\nLoop 12")
    // pętla funkcyjna map

    val listDecreasedValues = list.map(item => item - 5) //generuje nową listę, gdzie każdy element jest pomniejszony o 5
    listDecreasedValues.foreach(println(_))

    /////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////
  }
}
