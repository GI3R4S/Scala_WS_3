object ObjectCompanion {
  def main(args: Array[String]) {
    //Tworzenie obiektu klasy 'Rectangle'
    val rectangle = new Rectangle(20, 10)
    rectangle.print()

    //Wywołanie metody 'print' z obiektu 'RectangleSingleton'
    RectangleSingleton.print()


    //Obiekty towarzyszące
    val rectangle1: RectangleCompanion = RectangleCompanion()

    rectangle1.print()

    //Wypisanie prywatnej zmiennej
    rectangle1.printPrivate()

    val tupleOfInt = RectangleCompanion.unapply(rectangle1)
    println(tupleOfInt)
    val string = RectangleCompanion.unapply(rectangle1, boolean = true)
    println(string)
  }
}

class Rectangle(length: Int, height: Int) {
  def print(): Unit = println(s"Rectangle (class): length = $length, height = $height")
}

object RectangleSingleton {
  var length = 10
  var height = 20

  def print(): Unit = println(s"Rectangle (singleton): length = $length, height = $height")
}

class RectangleCompanion() {
  var length = 20
  var height = 10

  def print(): Unit = println(s"Rectangle (companion): length = $length, height = $height")

  def printPrivate(): Unit = println(RectangleCompanion.privateVal)
}

object RectangleCompanion {
  private val privateVal = 10
  def apply(): RectangleCompanion = new RectangleCompanion()

  def unapply(rectangleCompanion: RectangleCompanion): (Int, Int) = (rectangleCompanion.length, rectangleCompanion.height)

  def unapply(rectangleCompanion: RectangleCompanion, boolean: Boolean): String
  = s"${rectangleCompanion.length}, ${rectangleCompanion.height}"
}

// Po co?
// - dostęp do prywatnych pól i metod w obie strony
// - tworzenie nowych instancji bez słowa kluczowego 'new' (kompilator stosuje metodę 'apply')
//      val rectangle1: RectangleCompanion = RectangleCompanion()
//      val rectangle1: RectangleCompanion = RectangleCompanion.apply()
// - możliwość wielu różnych metod apply w celu dostarczenia wielu konstruktorów
// - 'unapply' w celu rozbicia instancji klasy na indywidualne komponenty
