

//WAP to create singleton class.




// Case is the singleton class here
object  Case
{
    fun message(){
        print("This is a singleton class")
    }
}

fun main()
{
    val obj = Case
    val obj1 = Case

// If we print the ID then both will point to the same ID so memory doesn't waste
    println(obj.toString())
    println(obj1.toString())
//Or we can call any function and Properties without making its object

    println(Case.message())
}