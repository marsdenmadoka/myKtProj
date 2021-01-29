// data class Grocery(val name:String,
//                   val category:String,
//                   val unit:String,
//                   val unitPrice:Double,
//                   val quantity:Int
//)
//fun main(args:Array<String>){
//    val groceries= listOf(Grocery("Tomatoes","Vegetable","lb",3.0,3),
//                      Grocery("Mushrooms","Vegetable","lb",4.0,1),
//                      Grocery("Bagels","Bakery","pack",1.5,2),
//                      Grocery("Olive oil","Pantry","Bottle",6.0,1),
//                      Grocery("Ice cream","Frozen","Pack",3.0,2) )
//
//    val highestUnitPrice=groceries.maxBy { it.unitPrice} //{ it.unitPrice*5}
//    println("highestUnitPrice:$highestUnitPrice")
//    val lowestQuantity=groceries.minBy { it.quantity }
//    println("lowesrQuantity:$lowestQuantity")
//
//    val sumQuantity=groceries.sumBy { it.quantity }
//    println("sumQuantity:$sumQuantity")
//    val totalPrice=groceries.sumByDouble { it.quantity * it.unitPrice }
//    println("totalPrice:$totalPrice")
//
//
//
//}
//




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
    println("notFrozen: $notFrozen")

    val groceryNames=groceries.map { it.name }
    println("groceryNames: $groceryNames")

    val halfUnitPrice=groceries.map{it.unitPrice * 0.5}
    println("halfUnitPrice: $halfUnitPrice")

     val newPrices=groceries.filter { it.unitPrice>3.0 }
             .map { it.unitPrice * 2 }
      println("newPrices: $newPrices")

    println("Grocery names: ")
    groceries.forEach { println(it.name) }

    println("Groceries with unitPrice > 3.0: ")
    groceries.filter { it.unitPrice>3.0 }
            .forEach { println(it.name) }


    var itemNames= ""
    groceries.forEach ({ itemNames += " ${it.name}" })
    println("itemNames: $itemNames")

    println("...................................................")
    println("...................................................")
    println("...................................................")

    // fold function Use groupBy to divide a collection into groups. It takes one parameter, a lambda, which defines how the function should group
    //the items. The function returns a Map, which uses the lambda criteria for the keys, and a List for each value.
    groceries.groupBy { it.category }.forEach{ //grouping items by category
        println("this category contains ${it.key}")
        it.value.forEach{ println(" items are ${it.name}")}
        println("...................................................")
    }

    val ints = listOf(2,2,3)
    val sumOfInts=ints.fold(0){ runningSum,item -> runningSum + item}
    println("sumOfInts: $sumOfInts")

    val productOfInts=ints.fold(1) { runningProducts, item -> runningProducts * item }
    println("productOfInts: $productOfInts")

    val names=groceries.fold(" ") {string,item -> string + " ${item.name}"}
    println("names: $names ")

    val changeFrom50=groceries.fold(50.0){change,item -> change - item.unitPrice * item.quantity}
  println("changeFrom50: $changeFrom50")

}

