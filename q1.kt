

// WAP to produce NoClassDefFoundError and ClassNotFoundException exception.

/*To solve this question we have used cammand line or terminal we manually compile this file
using kotlinc filename.kt and then two .class files will generate and when we delete one of inside 
.class file here Case.class and when we run it, it will produce  NoClassDefFoundError and ClassNotFoundException */



fun main(){
    println("hllo")
    var obj = Case()
    obj.message()
   
}


class Case{

    fun message(){
        println("I am a method")
    }
}




