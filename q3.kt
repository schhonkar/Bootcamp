
// Write a program to find the number of occurrences of a character in a string without using loop

fun main(){
    var str = "hello abcee"
    var c = 'e'
    var count = str.length - str.replace(c.toString(),"").length
    println("the occurrences of the character $c are $count")
}