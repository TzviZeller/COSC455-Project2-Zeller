//Tzvi Zeller
//Project 2 - warmup

//import for data structures
import scala.collection.mutable.Stack

//funtion calls for test cases
//#1
var num: Int = 37
prime(num)

//#2
var num2: Int = 43
twinPrime(num, num2)

//#3
var numlist: List[Int] = twinPrimeList(50)

//#4


//function to test if an int is prime
def prime(n: Int): Boolean = {
  (2 until n) forall (n % _ != 0) //redo
}

//funtion to test if 2 numbers are twinprimes
def twinPrime(n: Int, i: Int): Boolean = {
  if (prime(n) && prime(i)) {
    if ((n - i == 2) || (i - n == 2)) {
      return true
    }
    else
      return false
  }
  else
    return false
}

//funtion to return list of prime numbers up to num //@@fix
def twinPrimeList(n: Int): List[Int] = {
  var alist = Stack[Int]()
  if (prime(n)) {
    if (twinPrime(n, n - 2)) {
      alist.push(n)
      alist.push(n - 2)
    }
    if (!n.equals(1)) {
      twinPrimeList(n - 1)
    }
    else
      return alist.toList
  }

  else {
    twinPrimeList(n - 1)
  }
}

//function for goldback
def goldbach(n: Int): (Int, Int) = {
  if (goldhelp(n)) {

  }
  else
    println("Integer was not above 2 or not positive")
  return (-1,-1)
}

def goldhelp(n: Int): Boolean = {
  if ((n >= 2) && (n % 2 == 0))
    return true
  else
    return false
}