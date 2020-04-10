object LambdaFunctions {
  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6)

    println("Without lambda")
    for (number <- numbers) {
      println(number)
    }

    println("\n\nLambda 1")
    numbers.foreach { number: Int => println(number) }

    println("\n\nLambda 2")
    numbers.foreach {
      println(_)
    }

    println("\n\nLambda 3")
    numbers.foreach(println)

    println("\n\nLambda 4")
    numbers foreach println



    var sum = 0
    println("\n\nLambda sum")
    numbers.foreach(sum += _)
    println(sum)
    assert(sum == 21)


    val oddNumbers = numbers.filter((number: Int) => number % 2 != 0)
    println("\n\nOdd numbers")
    println(oddNumbers)
    assert(oddNumbers.size == 3)
    assert(oddNumbers(0) == 1 && oddNumbers(1) == 3 && oddNumbers(2) == 5)


    val evenNumbers = numbers.filterNot((number: Int) => number % 2 != 0)
    println("\n\nEven numbers")
    println(evenNumbers)
    assert(evenNumbers.size == 3)
    assert(evenNumbers(0) == 2 && evenNumbers(1) == 4 && evenNumbers(2) == 6)


    val squaredNumbers = numbers.map((number: Int) => number * number)
    println("\n\nSquared numbers")
    println(squaredNumbers)
    assert(squaredNumbers.size == 6)
    assert(squaredNumbers(0) == 1 && squaredNumbers(1) == 4 && squaredNumbers(2) == 9
      && squaredNumbers(3) == 16 && squaredNumbers(4) == 25 && squaredNumbers(5) == 36)


    val squareFunction = (number: Int) => number * number

    val squaredNumbers2 = numbers.map(squareFunction)
    println("\n\nSquared numbers 2")
    println(squaredNumbers2)
    assert(squaredNumbers2.size == 6)
    assert(squaredNumbers2(0) == 1 && squaredNumbers2(1) == 4 && squaredNumbers2(2) == 9
      && squaredNumbers2(3) == 16 && squaredNumbers2(4) == 25 && squaredNumbers2(5) == 36)


    def squareNumbersInList(list: List[Int], function: Int => Int) = list.map(function)

    val squaredNumbers3 = squareNumbersInList(numbers, (number: Int) => number * number)
    println("\n\nSquared numbers 3")
    println(squaredNumbers3)
    assert(squaredNumbers3.size == 6)
    assert(squaredNumbers3(0) == 1 && squaredNumbers3(1) == 4 && squaredNumbers3(2) == 9
      && squaredNumbers3(3) == 16 && squaredNumbers3(4) == 25 && squaredNumbers3(5) == 36)
  }
}
