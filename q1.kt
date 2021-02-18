

// Write a program to print your Firstname,LastName & age using init block,companion object.

class Details{
    init {
        var firstName = "Saurabh"
        var lastName = "Chhonkar"
        var age = 21
        println("This is inside init block: ")
        println("My first name is $firstName")
        println("My last name is $lastName")
        println("My age is $age")
    }

    companion object{
        val fName = "Saurabh"
        val lName = "Chhonkar"
        val ag = 21
        fun printDetails(){
            println("This is inside companion object")
            println("My first name is $fName")
            println("My last name is $lName")
            println("My age is $ag")
        }
    }
}

fun main() {
    //TO print the content of init block we have to make the object of the class
    val obj = Details()
    //but we can call the function inside the companion object without making the object of the class
    Details.printDetails()

}