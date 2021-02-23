

//WAP to create extension function.


class Student{
    fun isPassed(mark: Int): Boolean{
        return mark>40
    }
}
//We can also make custom type of extention of our class type
fun Student.isExcellent(mark: Int): Boolean{
    return mark > 90
}


//removing first and last element of the String this extention is for String class

fun String.removeFirstLastChar(): String =  this.substring(1, this.length - 1)


//main function
fun main(args: Array<String>) {

// For String class
    val myString= "Saurabh"
    val result = myString.removeFirstLastChar()
    println("String after removing first and last character: $result")
//For custom class type
    val student = Student()
    val passingStatus = student.isPassed(55)
    println("student passing status is $passingStatus")

    val Status = student.isExcellent(95)
    println("student excellent status is $Status")
}
