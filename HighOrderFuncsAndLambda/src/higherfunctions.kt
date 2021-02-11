//**
data class Grocery(val name:String,
                   val category:String,
                   val unit:String,
                   val unitPrice:Double,
                   val quantity:Int
)
fun main(args:Array<String>){
    val groceries= listOf(Grocery("Tomatoes","Vegetable","lb",3.0,3),
                      Grocery("Mushrooms","Vegetable","lb",4.0,1),
                      Grocery("Bagels","Bakery","pack",1.5,2),
                      Grocery("Olive oil","Pantry","Bottle",6.0,1),
                      Grocery("Ice cream","Frozen","Pack",3.0,2) )

    val highestUnitPrice= groceries.maxByOrNull { it.unitPrice } //{ it.unitPrice*5}
    println("highestUnitPrice:$highestUnitPrice")////returns to the item in groceries with highest unit price

    val lowestQuantity= groceries.minByOrNull { it.quantity }//returns to the item in groceries with the lowest quantity
    println("lowesrQuantity:$lowestQuantity")

    val sumQuantity=groceries.sumBy { it.quantity }//returns the sum of all quantity values in groceries
    println("sumQuantity:$sumQuantity")//sumBy adds Ints together, and returns an Int.
//myMap.values.sumBy { it }--returns sum of a maps values
    //to return the sum of each unitPrice multiplied by the quantity value, you would use sumByDouble, as unitPrice * quantity is a Double:
    val totalPrice=groceries.sumByDouble { it.quantity * it.unitPrice }
    println("totalPrice:$totalPrice")//sumByDouble adds Doubles, and returns a Double

    val veges=groceries.filter { it.category == "Vegetable" }
    println("$veges") //returns a list containing those items from groceries whose category value is "Vegetable"


    val TotalSpentVegetable =groceries.filter { it.category=="Vegetable" }.sumByDouble { it.unitPrice * it.quantity }
    println("total spent on vegetables is $TotalSpentVegetable")

    val listItemlessThan50=groceries.filter { it.unitPrice * it.quantity < 50}.map { it.name}
    println("list for item less than 50 $listItemlessThan50")

    val totalCostEachCategory=groceries.groupBy { it.category }.forEach{
        println("Total cost in category ${it.key}:  is ${it.value.sumByDouble { it.unitPrice * it.quantity }}")
    }


    val nameOfitemthatdoesntcomeinabottle=groceries.filter { it.unit == "Bottle"}.groupBy {it.unit}.forEach{
        print("name Of item that doesnt come in a ${it.key}")
        it.value.forEach { println(" is ${it.name}") }
    }



}
 //**/




/**
data class Grocery(val name:String,
                   val category:String,
                   val unit:String,
                   val unitPrice:Double,
                   val quantity:Int
)
fun main(args:Array<String>){

    val groceries= listOf(Grocery("Tomatoes","Vegetable","lb",3.0,3),
            Grocery("Mushrooms","Vegetable","lb",4.0,1),
            Grocery("Bagels","Bakery","pack",1.5,2),
            Grocery("Olive oil","Pantry","Bottle",6.0,1),
            Grocery("Ice cream","Frozen","Pack",3.0,2))

    //filter function The filter function lets you search, or filter, a collection according to some criteria. You specify this criteria using a lambda,
   // whose lambda body must return a Boolean. filter usually returns  a List . If the function is being used with a Map, however, it returns a Map instead.
    val vegetables=groceries.filter { it.category == "Vegetable" }
   println("vegetables: $vegetables")

    val notFrozen=groceries.filterNot { it.category== "Frozen" }
    println("notFrozen: $notFrozen")//returns those items in a collection which don’t match the criteria you pass to it i.e whose category value is not “Frozen”:

    //In each case, the map function returns a new List, and leaves the original collection intact
    val groceryNames=groceries.map { it.name }
    println("groceryNames: $groceryNames")//you can also use map to create a new List containing the name of each Grocery item in groceries:

    val halfUnitPrice=groceries.map{it.unitPrice * 0.5}//returns a list containing each unitPrice multiplied by 0.5
    println("halfUnitPrice: $halfUnitPrice")

     val newPrices=groceries.filter { it.unitPrice>3.0 }//create a List of each unitPrice multiplied by two, where the original unitPrice is greater than 3.0
             .map { it.unitPrice * 2 }//this calls the filter function and then calls map on the resultinglist
      println("newPrices: $newPrices")

    println("Grocery names:")//The forEach function works in a similar way to a for loop
    groceries.forEach { println(it.name) }//You can use forEach with arrays, Lists, Sets, and on a Map’s entries, keys and values properties.

    println("Groceries with unitPrice > 3.0: ")//Imagine that you want to print the name of each item in groceries whose unitPrice is greater than 3.0.
    groceries.filter { it.unitPrice>3.0 }//forEach lets you chain function calls together to perform powerful tasks in a way that’s concise.
            .forEach { println(it.name) }

   // When you pass a lambda to a higher-order function such as forEach, the lambda has access to these same variables, even though they’ve been defined outside the
    //lambda. This means that instead of using the forEach function’s return value to get the result of some calculation, you can update a variable from inside thelambda body
    var itemNames= ""   //variables defined outside the lambda which the lambda can access are sometimes referred to as the lambda’s closure.
    groceries.forEach ({ itemNames += " ${it.name}" })
    println("itemNames: $itemNames")

    println("...................................................")
    println("...................................................")
    println("...................................................")

//The following code, for example, groups the items in groceries (a List<Grocery>) by the category value:
    groceries.groupBy { it.category }.forEach{ //groupBy returns a Map,wihci means that we can call the forEach function on its return value.items by category
        println("this category of ${it.key} contains") //prints the Map keys(Grocery category values)
        it.value.forEach{ println(" ${it.name}")} //gets the corresponding value for the Maps key
        println("...................................................")
    }

    // fold function Use groupBy to divide a collection into groups. It takes one parameter, a lambda, which defines how the function should group
    //the items. The function returns a Map, which uses the lambda criteria for the keys, and a List for each value.
    val ints = listOf(1,2,3) //fold takes two parameters: the initial value, and the operation that you want to perform on it,specified by a lambda
    val sumOfInts=ints.fold(0){ runningSum,item -> runningSum + item}//This creates an Int variable named runningSum which is initialized with 0
    println("sumOfInts: $sumOfInts")

    val productOfInts=ints.fold(1) { runningProducts, item -> runningProducts * item }
    println("productOfInts: $productOfInts")

    val names=groceries.fold(" ") {string,item -> string + " ${item.name}"}
    println("names: $names ")

    val changeFrom50=groceries.fold(50.0){change,item -> change - item.unitPrice * item.quantity}
  println("changeFrom50:= $changeFrom50")

}
**/



/**
fun main(args:Array<String>){
    var addFive={x:Int->x+5}
    println("pass 6 to addfive:${addFive(6)}" )

    val addInts={x:Int,y:Int -> x+y}
    val result = addInts.invoke(6,7)
    println("pass 6,7 to addInts:$result")

    val intLambda:(Int,Int)-> Int = {x,y->x*y}
    println("pass 10,11 to intLambda: ${intLambda(10,11)}")

    val addseven:(Int) -> Int = {it + 7}
    println("pass 12 to addSeven: ${addseven(12)}")

    val myLambda:() -> Unit={ println("Hi!")}
    myLambda()

} **/


//A function that uses a lambda as a parameter or return value is known as a higher-order function.
/**
//Add a lambda parameter to a function by specifying its name and type
fun convert(x:Double,
            converter:(Double)-> Double):Double {
    val result=converter(x)//invokes the lambda named converter and assigns its return value to result
    println("$x is converted to $result")
    return result //return the result
}
fun convertFive(converter: (Int) -> Double):Double{
    val result = converter(5)
    println("5 is converted to $result")
    return result
}

fun main(args:Array<String>){ //convert 20.0 degrees centrigrade to fahrenheit To do this, we’ll pass values of 20.0 and { c: Double -> c * 1.8 + 32 } to the function
    convert(20.0){it * 1.8 + 32}
    //  convert(20.0,{c:Double -> c * 1.8 + 32})

    convertFive { it * 1.8 + 32 }


   println("convert 2.5kgs to pounds ${getConversionLambda("KgsToPounds")(2.5)}")//here we are passing getConversionLambda return value to the convert function

}//


//A function can return a lambda
fun getConversionLambda(str:String):(Double) -> Double{
    if(str == "CentigradeToFahrenheit"){
        return{it * 1.8 + 32}
    }else if (str == "KgsToPounds"){
        return {it * 2.204623}
    }else if (str == "PondsToUSTons"){
        return { it/2000.0 }
    }else{
        return { it} //the function returns one of the lambdas
    }
}

//Write a function that receives AND returns lambdasWrite a function that receives AND returns lambdas
fun combine(lambda1:(Double) -> Double,
             lambda2:(Double) -> Double):(Double)-> Double{
    return {x:Double -> lambda2(lambda1(x))} //x is passed to lambda1 wich accepts and returns a double,The result is then passed to lambda2,which also accepts and returns a double
 //the lambda returned by combine takes a Double parameter named x

}



//You can, however, make your code more readable by replacing the function type with a type alias.
typealias Doubleconversion=(Double) -> Double //this typealias means that we can use DoubleConversion in place of (Double)->Double
fun converta(x:Double,
               converter:Doubleconversion):Double{
    val result = converter(x)
    return  result
}
fun combinea(lambda1:Doubleconversion,
             lambda2: Doubleconversion):Doubleconversion{
    return {x:Double -> lambda2(lambda1(x))}
}

**/

















