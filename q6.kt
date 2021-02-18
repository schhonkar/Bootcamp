

//Write a program to create mutable list of Integer. replace the second item in the list with new value. Print the list value.

fun main() {
    var list = mutableListOf<Int>(2,3,4,5,6,7)
    println("Printing list before changing secand element: ")
    println(list)
    var element = 10
    list[1] = element
    println("Printing list after changing secand element with $element: ")
    println(list)
}