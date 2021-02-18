

//Write a program to create mutable map. print all the value and key of map.

fun main() {
    val items = mutableMapOf(1 to "Saurabh",2 to "Sriyansh",3 to "Abhishek",4 to "Hariom")
    println("Keys and values are")
    for (key in items.keys){
        println("key = $key, value = ${items[key]}")
    }
}