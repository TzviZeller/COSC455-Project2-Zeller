//Tzvi Zeller
//Project 2 - translation

//lib of language
val chinese: List[String] = List("ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu", "shi")
val english: List[String] = List("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten")

//testcase
go(List("yi","nine","six","ba"))
go(List("yi","josh","three","si"))

def go(alist: List[String]): Unit = {
  //define and sorts passed in var
  var output = List[Int]()
  output = sort(alist)

  //creates and provides output
  val addition = add(output)
  val multiplication = multi(output)
  println("Translation:" + output)
  println("Total addtion of the list " + addition)
  println("Total multiplication of the list " + multiplication)
  println()
}

//sort function checks list for shared vars
def sort(alist: List[String]): List[Int] = {
  alist match {
    case Nil => Nil
    case head :: tail =>
      if (chinese.contains(head)) {
        chinese.indexOf(head) :: sort(tail)
      }
      else if (english.contains(head)) {
        english.indexOf(head) :: sort(tail)
      }
      else
        sort(tail)
  }
}

//output for list add
def add(alist: List[Int]): Int = {
  alist.foldLeft(0)(_ + _)
}

//output for list multiplied
def multi(alist: List[Int]): Int = {
  alist.foldLeft(1)(_ * _)
}