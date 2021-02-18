
/* Write a single program for following operation using overloading
  A) Adding 2 integer number
  B) Adding 2 double
  D) multiplying 2 int
  E) concate 2 string
  F) Concate 3 String */



class Operations() {

    fun sum(a: Int,b: Int){
        println("Sum of two Integers $a and $b is ${a+b}")
    }
    fun sum(a: Double,b: Double){
        println("Sum of two Doubles $a and $b is ${a+b}")
    }
    fun multiply(a: Int,b: Int){
        println("Multiply of two Integers $a and $b is ${a*b}")
    }
    fun concate(str1: String,str2: String){
        println("After concatinating two strings $str1 and $str2 is  ${str1+str2}")
    }
    fun concate(str1: String,str2: String, str3:String){
        println("After concatinating three strings $str1, $str2 and $str3 is ${str1+str2+str3}")
    }
}

fun main() {
    val obj = Operations()
    obj.sum(5,9)
    obj.sum(5.2,10.8)
    obj.multiply(4,8)
    obj.concate("jat","_james")
    obj.concate("jat","_james","_bond")
}