

//Create Kotlin classes having suitable attributes for Library management system.Use OOPs concepts in your design.Also try to use interfaces and abstract classes.


open abstract class Library {
    abstract fun showBooks()
}

class Books(val bookName:String,val bookAuthor:String):Library(){

    override fun showBooks() {
        println("Bookname is $bookName and Author is $bookAuthor")
    }
}
interface PrintEmployee {
    fun print()
}

class Employee(var empName:String): PrintEmployee{
    override fun print() {
        println("Employee name is: $empName")
    }
}

fun main() {
    var obj = Books("Atomic Habits","William john")
    var obj1 = Employee("Rahul")
    obj.showBooks()
    obj1.print()
}