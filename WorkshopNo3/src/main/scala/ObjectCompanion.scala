object ObjectCompanion {
  def main(args: Array[String]) {
    //Tworzenie obiektu klasy Rectangle
    val rectangle = new Rectangle(20, 10)
    rectangle.print()

    //Wywołanie metody print z obiektu RectangleSingleton
    RectangleSingleton.print()

    //Obiekty towarzyszące
    val rectangle1: RectangleCompanion = RectangleCompanion(5, 10)
    val rectangle2: RectangleCompanion = RectangleCompanion(10, 5)

    rectangle1.print()
    rectangle2.print()
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

class RectangleCompanion(length: Int, height: Int) {
  def print(): Unit = println(s"Rectangle (companion): length = $length, height = $height")
}

object RectangleCompanion {
  def apply(length: Int, height: Int): RectangleCompanion = new RectangleCompanion(length, height)
}