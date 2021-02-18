
/*Write a function which take marks as an argument and return the the grade as follows:
    1)marks between 50 to 60 , return “Good”
    2)marks between 60 to 70, return “Very Good”
    3)marks between 70 to  80, return “Excellent”
    4)marks between  80 to 100, return “Rockstar” */



fun main(){
    fun calculateMarks(marks:Int){
        return when(marks){
            in 50..60 -> println("$marks is Good")
            in 60..70 -> println("$marks is Very Good")
            in 70..80 -> println("$marks is Excellent")
            in 80..100 -> println("$marks is Rockstar")
            else -> println("$marks is Bad")
        }
    }

    calculateMarks(45)
}