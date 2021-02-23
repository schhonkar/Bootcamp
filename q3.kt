

/* WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have base class object as an argument and it will return name of the subclass based argument type. */

sealed class Base {

    class Tiger:Base(){}
    class Lion:Base(){}
    class Elephant:Base(){}

}

fun getClassName(base:Base){
    when(base){
        is Base.Tiger -> println("Tiger class")
        is Base.Lion -> println("Lion class")
        is Base.Elephant -> println("Elephant class")
        else -> println("Invalid class")
    }
}



fun main() {
    var obj = Base.Tiger()
    var obj1 = Base.Lion()
    var obj2 = Base.Elephant()
    getClassName(obj)
    getClassName(obj1)
    getClassName(obj2)
}
