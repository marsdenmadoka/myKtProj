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
                      Grocery("Ice cream","Frozen","Pack",3.0,2)
    )

    val highestUnitPrice=groceries.maxBy { it.unitPrice} //{ it.unitPrice*5}
    println("highestUnitPrice:$highestUnitPrice")
    val lowestQuantity=groceries.minBy { it.quantity }
    println("lowesrQuantity:$lowestQuantity")

    val sumQuantity=groceries.sumBy { it.quantity }
    println("sumQuantity:$sumQuantity")
    val totalPrice=groceries.sumByDouble { it.quantity * it.unitPrice }
    println("totalPrice:$totalPrice")



}

