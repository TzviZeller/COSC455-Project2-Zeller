//Tzvi Zeller
//Project 2 - warmup

//import for data structures
import scala.collection.mutable.Stack

//funtion calls for test cases
//#1
var num: Int = 37
prime(num)

//#2
var num1: Int = 41
var num2: Int = 43
twinPrime(num1, num2)

//#3
var numlist: List[Int] = twinPrimeList(50)

//#4


//function to test if an int is prime
def prime(n: Int): Boolean = {
  (2 until n) forall (n % _ != 0)
}

//funtion to test if 2 numbers are twinprimes
def twinPrime(n: Int, i: Int): Boolean = {
  if (prime(n) && prime(i)) {
    if ((n - i == 2) || (n - i == -2) ) {
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
  twinPrimeListHelp(n,alist)

}

def twinPrimeListHelp(n: Int, alist: Stack[Int]): List[Int] = {
  if (prime(n)) {
    if (twinPrime(n, n - 2)) {
      alist.push(n)
      alist.push(n - 2)
    }
    if (!n.equals(2)) {
      twinPrimeListHelp(n - 1, alist)
    }
    else
      return alist.toList
  }

  else {
    twinPrimeListHelp(n - 1, alist)

}}

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