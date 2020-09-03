
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
fun main(args:Array<String>){
    var mShopingList= mutableListOf("Tea","Eggs","Milk")
    println("mShopping original: $mShopingList")
    val extraShopping = listOf("Cookies","sugar","Eggs")
    mShopingList.addAll(extraShopping)
    println("mShoppingList items added: $mShopingList")
    if(mShopingList.contains("Tea")){
        mShopingList.set(mShopingList.indexOf("Tea"),"Coffee")
    }
    mShopingList.sort()
    println("mShopping list sorted $mShopingList")
    mShopingList.reverse()
    println("mShoppingList reversed $mShopingList")

    val mShoppingSet=mShopingList.toMutableSet() //copying our list into a set
    println("Mshopping set : $mShoppingSet")
    val moreShopping= setOf("Chives","Spinach","Milk")
    mShoppingSet.addAll(moreShopping)
    println("mShoppingSet items added: $mShoppingSet")
    mShopingList=mShoppingSet.toMutableList()
    println("mShoppingList new version: $mShopingList")


}


//mapOf