

// Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String.

fun main(){
    val str = "HelloMy@001_kHGFsfjsk"
    var upperCase = 0
    var lowerCase = 0
    var digits = 0
    var others = 0
    var len = str.length

    for (c in str){
        when{
            c.isDigit() -> digits++
            c.isLowerCase() -> lowerCase++
            c.isUpperCase() -> upperCase++
            else -> others++
        }
    }
    println("the percentage of lowerCase letters are ${(lowerCase*100)/len}%")
    println("the percentage of upperCase letters are ${(upperCase*100)/len}%")
    println("the percentage of Digits letters are ${(digits*100)/len}%")
    println("the percentage of others letters are ${(others*100)/len}%")

}