

// Write a program to create HasSet. print all the value.

fun main() {
    var hset = hashSetOf(5,8,9,4,3,5,7)
    //Adding element using add method hashSet doesn't contain duplicates
    hset.add(6)
    println("Items in HashSet are: ")
    for (items in hset){
        print("$items ")
    }
}