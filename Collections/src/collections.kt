
////mutablelists i.e ist that can be updated
//list is ordered lke array ie u can get ites at index
//fun main(args:Array<String>){
//    val mShopingList= mutableListOf("Tea","Eggs","Milk")
//    println("mShopping original: $mShopingList")
//    val extraShopping = listOf("Cookies","sugar","Eggs")
//    mShopingList.addAll(extraShopping)
//    println("mShoppingList items added: $mShopingList")
//    if(mShopingList.contains("Tea")){
//        mShopingList.set(mShopingList.indexOf("Tea"),"Coffee")
//    }
//    mShopingList.sort()
//    println("mShopping list sorted $mShopingList")
//    mShopingList.reverse()
//    println("mShoppingList reversed $mShopingList")
//
//}


//SET is a collection that does not allow duplicate to be used
//the Set ignores the duplicate values set are unordered
//A Set’s values are unordered, so unlike a List, there’s no get function you can
//use to get the value at a specified index
//fun main(args:Array<String>){
//    var mShopingList= mutableListOf("Tea","Eggs","Milk")
//    println("mShopping original: $mShopingList")
//    val extraShopping = listOf("Cookies","sugar","Eggs")
//    mShopingList.addAll(extraShopping)
//    println("mShoppingList items added: $mShopingList")
//    if(mShopingList.contains("Tea")){
//        mShopingList.set(mShopingList.indexOf("Tea"),"Coffee")
//    }
//    mShopingList.sort()
//    println("mShopping list sorted $mShopingList")
//    mShopingList.reverse()
//    println("mShoppingList reversed $mShopingList")
//
//    val mShoppingSet=mShopingList.toMutableSet() //copying our list into a set
//    println("Mshopping set : $mShoppingSet")
//    val moreShopping= setOf("Chives","Spinach","Milk")
//    mShoppingSet.addAll(moreShopping)
//    println("mShoppingSet items added: $mShoppingSet")
//    mShopingList=mShoppingSet.toMutableList()
//    println("mShoppingList new version: $mShopingList")
//
//}


//mapOf
//You can copy a Map or MutableMap into a new List object containing all the
//key/value pairs using toList like this:
data class Recipe(var name:String) //add the recipe data class
fun main(args:Array<String>){
    //set
    val r1=Recipe("Chicken Soup")
    val r2=Recipe("Quinoa Salad")
    val r3=Recipe("Thai Curry")
    val r4=Recipe("Jambalaya")
    val r5=Recipe("Sausage Rolls")
    val mRecipeMap= mutableMapOf("Recipe1" to r1,"Recipe2" to r2,"Recipe3" to r3)
     println("mRecipeMap original: $mRecipeMap")
    val recipesToAdd= mapOf("Recipe4" to r4,"Recipe5" to r5)
    mRecipeMap.putAll(recipesToAdd) //put our first hashMap to the second after we have updated
    println("mRecipeMap updated: $mRecipeMap")
     if (mRecipeMap.containsKey("Recipe1")){
         println("Recipe1 is: ${mRecipeMap.getValue("Recipe1")}")
     }
}


//fun main(args: Array<String>) {
//    val term1 = "Array"
//    val term2 = "List"
//    val term3 = "Map"
//    val term4 = "MutableList"
//    val term5 = "MutableMap"
//    val term6 = "MutableSet"
//    val term7 = "Set"
//
//    val def1 = "Holds values in no particular order."
//    val def2 = "Holds key/value pairs."
//    val def3 = "Holds values in a sequence."
//    val def4 = "Can be updated."
//    val def5 = "Can't be updated."
//    val def6 = "Can be resized."
//    val def7 = "Can't be resized."
//
//      val glossary = mapOf(
//        term4 to "$def3 $def4 $def6",
//        term7 to "$def1 $def5 $def7",
//        term1 to "$def3 $def4 $def7",
//        term5 to "$def2 $def4 $def6",
//        term2 to "$def3 $def5 $def7",
//        term6 to "$def1 $def4 $def6",
//        term3 to "$def2 $def5 $def7")
//
//        for ((key, value) in glossary)
//        println("$key: $value")
//}
