//Tzvi Zeller
//Project 2 - Binary


//main function to drive
def binaryAddition(pList: List[Int], qList: List[Int]): List[Int] = {
  var intlist1 = pList.reverse
  var intlist2 = qList.reverse
  var bool1: List[Boolean] = convertIntListToBooleanList(intlist1)
  var bool2: List[Boolean] = convertIntListToBooleanList(intlist2)
  var output: List[Boolean] = doBinaryAddition(bool1, bool2, false)
  var intfin: List[Boolean] = output.reverse
  var boolfin: List[Int] = convertBooleanListToIntList(intfin)
  boolfin
}



// This function does the binary addition of two boolean lists. Note that the lists may not be equal in length.
def doBinaryAddition(pBits: List[Boolean], qBits: List[Boolean], carryBit: Boolean): List[Boolean] = {
  (pBits.isEmpty) && (!qBits.isEmpty) && (carryBit == true) match {
    case true => finishBinaryAdd(qBits, carryBit)
    case false =>
      (!pBits.isEmpty) && (qBits.isEmpty) && (carryBit == true) match {
        case true => finishBinaryAdd(pBits, carryBit)
        case false =>
          (!pBits.isEmpty) && (!qBits.isEmpty) match {
            case true => addBits(pBits.head, qBits.head, carryBit) :: doBinaryAddition(pBits.tail, qBits.tail, getNextCarryBit(pBits.head, qBits.head, carryBit))
            case false => Nil
          }
      }
  }
}

// This function does the binary addition when there are uneven lists and still must
// finish the add with the carry bits.
def finishBinaryAdd(remainingBits: List[Boolean], carryBit: Boolean): List[Boolean] = {
  ((!remainingBits.isEmpty) && (carryBit == false)) match {
    case true => remainingBits
    case false =>
      ((remainingBits.isEmpty) && (carryBit == true)) match {
      case true => List(true)
      case false =>
        ((!remainingBits.isEmpty) && (carryBit == true)) match {
        case true => !remainingBits.head :: finishBinaryAdd(remainingBits.tail, remainingBits.head)
      }
    }
  }
}

// This function determines what the next carry bit should be based on current bits.
def getNextCarryBit(pBit: Boolean, qBit: Boolean, carryBit: Boolean): Boolean = {
  ((pBit && qBit) || (pBit && carryBit) || (qBit && carryBit))
}

// This function does the binary addition of two Booleans and a carry bit.
def addBits(pBit: Boolean, qBit: Boolean, carryBit: Boolean): Boolean = {
  (carryBit == (pBit == qBit))

}

// This function converts a binary integer list into its corresponding boolean list.
def convertIntListToBooleanList(intList: List[Int]): List[Boolean] = {
  intList.map {
    case 0 => false
    case 1 => true
  }
}

// This function converts a boolean list into its corresponding binary integer list.
def convertBooleanListToIntList(booleanList: List[Boolean]): List[Int] = {
  booleanList.map {
    case false => 0
    case true => 1
  }
}

// Test Cases
val pTest1: List[Int] = List(1, 1, 1, 1, 0)
val qTest1: List[Int] = List(1, 0, 1, 1)
val test1ExectedSolution: List[Int] = List(1, 0, 1, 0, 0, 1)

val pTest2: List[Int] = List(1, 0, 0, 1, 1, 0, 1)
val qTest2: List[Int] = List(1, 0, 0, 1, 0)
val test2ExectedSolution: List[Int] = List(1, 0, 1, 1, 1, 1, 1)

val pTest3: List[Int] = List(1, 0, 0, 1, 0, 0, 1)
val qTest3: List[Int] = List(1, 1, 0, 0, 1)
val test3ExectedSolution: List[Int] = List(1, 1, 0, 0, 0, 1, 0)

val pTest4: List[Int] = List(1, 0, 0, 0, 1, 1, 1)
val qTest4: List[Int] = List(1, 0, 1, 1, 0)
val test4ExectedSolution: List[Int] = List(1, 0, 1, 1, 1, 0, 1)

// Testing binary addition.
if (binaryAddition(pTest1, qTest1).equals(test1ExectedSolution)) println("Test 1 passes!") else println("Test 1 fails.")
if (binaryAddition(pTest2, qTest2).equals(test2ExectedSolution)) println("Test 2 passes!") else println("Test 2 fails.")
if (binaryAddition(pTest3, qTest3).equals(test3ExectedSolution)) println("Test 3 passes!") else println("Test 3 fails.")
if (binaryAddition(pTest4, qTest4).equals(test4ExectedSolution)) println("Test 4 passes!") else println("Test 4 fails.")




