

//WAP using Lambda function to calculate the Simple Interest.

fun main(){

    var principal = 10000
    var rateOfInterest:Double = 6.7
    var time = 2

    //Lambda function
    var si = {p:Int,r:Double,t:Int -> (p*r*t)/100}

    println("the simple interest is ${si(principal,rateOfInterest,time)}")

}