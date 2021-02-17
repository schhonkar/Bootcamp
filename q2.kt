

//Write a program to find the number of occurrences of the duplicate words in a string and print them.



fun main() {
    var input: String = "One Two one Four Five two one four"
    input = input.toLowerCase()

    var arr = input.split(" ")
    arr = arr.toMutableList()
    println("Duplicates words with occurrences: ")
    var count:Int
    for (i in 0..arr.size){
        count = 1
        for (j in i+1..arr.size-1){
                if (arr[i] == arr[j]){
                    count += 1
                    arr[j] = "o"
            }
        }
        if (count > 1 && arr[i] != "o"){
            var word = arr[i]
            println("$word occurred $count times")

        }
    }
}


