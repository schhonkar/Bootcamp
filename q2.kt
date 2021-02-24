

//Create a list of Employee which will have name and age as properties. print the name of all employees age >30.

data class Employee(val name:String,val age:Int)

fun main() {
    var list: List<Employee> = mutableListOf(
            Employee("saurabh",21),
            Employee("Naveen",32),
            Employee("Abhishek",35),
            Employee("Riya",24),
            Employee("Mohan",37),
            Employee("Raju",29),
            Employee("Shakti",28)
    )
    val result = list.filter { Employee -> Employee.age > 30
    }
    println("Employees with age greater than 30 are: ")

    for (items in result){
        println("${items.name} is ${items.age} years old.")
    }
}