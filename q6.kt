
// Check letter in string which do not have pair.

fun main(){
    var str = "bootcamp"
    println("Letters without any pair: ")
    for (i in 0..str.length-1){
        if ((str.length - str.replace(str[i].toString(),"").length) == 1){
            println(str[i])
        }
    }


}

