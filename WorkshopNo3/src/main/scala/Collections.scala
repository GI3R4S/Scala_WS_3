import Array._
import scala.collection.immutable._

object Collections {
  def main(args: Array[String]) {

    //////////////////////////////////////
    // Array /////////////////////////////
    //////////////////////////////////////

    val numbersArray = Array(1, 2, 3, 4, 5, 6) // 'val' uniemożliwi nadpisanie numbersArray przez inną instancję Array,
    // lecz elementy numbersArray są wciąż modyfikowalne !

    val numbersArrayWithSize = Array[Int](10)
    val numbersArrayWithNew = new Array[Int](10)
    val numbersArrayStrongTyping = Array[Int](1, 2, 3, 4, 5, 6) // Array[T] to odpowiednik T[] z Javy
    val numbersArrayFromRange = range(0, 20, 2) //  tworzenie tablicy przy pomocy 'range'

    var arrayItem = numbersArray(3) // odczytuje element spod podanego indeksu
    numbersArray(3) = 100 // zmienia wartość elementu spod indeksu '3'

    // numbersArray(10) odwołanie się do niewłaściwego indeksu spowoduje wygenerowanie wyjątku z Javy:
    //                  java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 6


    val multiDimensionalArray = Array.ofDim[Int](2, 4, 6) // utworzenie wielowymiarowego Arraya, podając
    // wielkość w każdym wymiarze

    multiDimensionalArray(1)(3)(5) // odwołanie się do ostatniego elementu wielowymiarowej tablicy

    // utworzenie nowej tablicy na podstawie 'numbersArray' rozszerzonej o dodatkowy element '20' na końcu
    val newArrayAppendItem = numbersArray :+ 20

    // utworzenie nowej tablicy na podstawie 'numbersArray' rozszerzonej o zawartość innej tablicy na końcu
    val newArrayAppendRange = numbersArray ++ numbersArrayFromRange

    // utworzenie nowej tablicy na podstawie 'numbersArray' rozszerzonej o dodatkowy element '20' na początku
    val newArrayAppendItemOnBeginning = 20 +: numbersArray

    // utworzenie nowej tablicy na podstawie 'numbersArray' rozszerzonej o zawartość innej tablicy na początku
    val newArrayAppendRangeOnBeginning = numbersArrayFromRange ++: numbersArray

    //////////////////////////////////////
    // Sequence //////////////////////////
    //////////////////////////////////////

    // Hierarchia traitów
    //
    //                   Traversable
    //                       |
    //                       |
    //                    Iterable
    //                       |
    //                      Seq
    //             |-------------------|
    //         IndexedSeq           LinearSeq

    //  Seq:
    //  - narzucają implementację metody 'apply'
    //  - kolekcja implementująca 'Seq' narzuca ułożenie elmentów w kolejności
    //  - kolekcja implementująca 'Seq' udostępnia metody związane ze znajdywaniem podciągów np.:
    //       segmentLength, prefixLength, indexWhere, indexOf, lastIndexWhere, lastIndexOf, startsWith, endsWith, indexOfSlice
    //  - IndexedSeq udostępnia  losowy dostęp dla elementów kolekcji, LinearSeq umożlwia szybki dostęp do pierwszego i ostatniego elementu kolekcji
    //  - IndexedSeq implementują: Vector, String, Range, NumericRange
    //  - LinearSeq implementują: List, Stack, Stream, Queue

    //////////////////////////////////////
    // List //////////////////////////////
    //////////////////////////////////////

    // - jest niemodyfikowalna
    // - implementuje LinearSeq - elementy są połączone ze sobą w okreslonej kolejności
    // - szybkie operacje na pierwszym(head) i ostatnim(tail) elemencie listy
    // - podobnie jak tablice, po utworzeniu są niemodyfikowalne
    val numbersList = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val numbersListStronglyTyped: List[Int] = List[Int](1, 2, 3, 4, 5)
    val numbersListMultiDimensional = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9)
    )
    val emptyList: List[Nothing] = List()
    val emptyListNil = Nil
    assert(emptyList == emptyListNil)

    val blockBuiltList = 1 :: (2 :: (3 :: (4 :: Nil)))  // listę można budować przy pomocy wartości, operatora '::'
                                                        // oraz słowa kluczowego 'Nil' reprezentującego koniec listy
                                                        // zawartość każdego nawiasu to lista

    val anotherList = List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
    //List.concat(list_1, list_2, list_3, ..., list_n) // łączy dowolną liczbę list

    val newListPrepend1 = -1 :: anotherList // łączenie list
    val newListPrepend2 = -1 :: anotherList // łączenie list
    val newListConcat = numbersList ::: anotherList // łączenie list

    assert(newListConcat.size == 20)

    val head = numbersList.head // dostęp do pierwszego elementu listy == 1
    val tail = numbersList.tail // dostęp do ostatniego elementu listy == 9
    numbersList.isEmpty // czy list jest pusta ?

    //numbersList.head = -1000 // nie można wykonać przypisania do elementu


    //  Dodatkowo możliwe jest wykorzystanie metod, które wynikają z hierarchii intefejsów takie jak odnalezienie minimum,
    //  maksimum, testowanie predykatów, filtracje, akumulacje itd.
    //

    //////////////////////////////////////
    // Tuple ////////////////////////////
    /////////////////////////////////////

    // - Umożliwia przechowywanie zmiennych różnego typu
    val exampleTuple = (1, 1.0f, "tekst", true)


    // - Przykład silnego typowania
    val exampleTupleStronglyTyped = (1, 1.0f, "tekst", true) : Tuple4[Int, Float, String, Boolean]


    // - Umożliwia przechowywanie dowolnej liczby elementów
    val exampleTupleOtherSize = (1, 1.0f, "tekst", true, 1, "d", 'f')


    // - Możliwe jest przypisanie wartości tupli do kilku zmiennych
    val (var_int, var_float, var_string, var_bool) = (1, 1.0f, "tekst", true)

    // - Liczba i typ elementów jest określana w momencie tworzenia zmiennej
    // - Umożliwia zagnieżdżanie w sobie innych tupli, list, dowolnych typów
    val exampleTuple2 = ((1, 2), (10, "g"), List('a', 'b', 'c'))

    assert(exampleTuple._1 == 1)
    assert(exampleTuple._2 == 1.0f)
    assert(exampleTuple._3 == "tekst")
    assert(exampleTuple._4 == true)

    // - zawartość utworzonej tupli jest niezmienna


  }
}
