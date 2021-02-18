

// Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide there specific details like rateofinterest etc,print details of every bank.

 open abstract class Bank(var bankName:String,var bankManagerName:String,var rateOfInterest:Double) {
     abstract fun getDetails()

}

class Sbi:Bank(bankName="SBI",bankManagerName = "Saurabh Chhonkar",rateOfInterest = 4.5){
    init {
        println("Details of the Bank: ")
    }
    override fun getDetails() {
        println("Bank name is: $bankName")
        println("Branch manager is: $bankManagerName")
        println("Rate of interest is: $rateOfInterest")
    }

}

class Icici:Bank(bankName="ICICI",bankManagerName = "Sandeep Tewatia",rateOfInterest = 5.5){
    init {
        println("Details of the Bank: ")
    }
    override fun getDetails() {
        println("Bank name is: $bankName")
        println("Branch manager is: $bankManagerName")
        println("Rate of interest is: $rateOfInterest")
    }

}

class Boi:Bank(bankName="BOI",bankManagerName = "Sriyansh Jain",rateOfInterest = 7.5){
    init {
        println("Details of the Bank: ")
    }
    override fun getDetails() {
        println("Bank name is: $bankName")
        println("Branch manager is: $bankManagerName")
        println("Rate of interest is: $rateOfInterest")
    }

}

fun main() {
    var a = Sbi()
    a.getDetails()
    var b = Icici()
    b.getDetails()
    var c = Boi()
    c.getDetails()
}