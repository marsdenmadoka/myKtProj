//A data class is one that lets you create objects whose main purpose is to store
//data You define a data class by prefixing a normal class definition with the data
/**
data class Recipe(val title:String, //assign default values to the isVegetarian and difficulty properties
                  val mainIngredient:String,//
                  val isVegetarian:Boolean=false,
                  val difficulty:String="Easy" )
{ //our body code
}
  //class with a secondary consructor
 class Mushroom(val size:Int,val isMagic:Boolean){
     constructor(isMagic_param: Boolean):this(0,isMagic_param){
         //code that runs when secondary constructor is called
     }
 }

//example of a function that uses default parameter values
fun findRecipes(title:String="",ingredient:String="",isVegetarian:Boolean=false,difficulty:String=""):Array<Recipe>{
    //code to find Recipes
    return arrayOf(Recipe(title,ingredient,isVegetarian,difficulty))
}

fun addNumbers(a:Int,b:Int):Int{ //overloaded functions
    return a + b
}
fun addNumbers(a:Double,b:Double):Double{ //overloaded functions
    return a + b
}


fun main(args:Array<String>) {
    val r1 = Recipe("Thai curry","chicken")
    val r2 = Recipe("Thai curry", "chicken")
    val r3 = r1.copy(title = "Chicken Bhuna")//create a copy of r1,altering its title property
    println("r1 hash code: ${r1.hashCode()}")
    println("r2 hash code: ${r2.hashCode()}")
    println("r3 hash code: ${r3.hashCode()}")
    println("r1 toString: ${r1.toString()}")
    println("r1 == r2 is ${r1 == r2}") //==checks using the hashcode
    println("r1 === r2 is ${r1 === r2}")//=== checks for object identity that is separate objects
    println("r1 == r3 is ${r1 == r3}")
    println("r2== r3 is ${r2 == r3}")
    println("r1 === r3 is ${r1 === r3}")
    println("r2=== r3 is ${r2 === r3}")
    val (title, mainIngredient,vegetarian,difficulty) = r1 //destructure r1
    println("title is $title and vegetarian is $vegetarian")
   val m1=Mushroom(6,false) //create a mushroom by calling its primary constructor
    println("m1 size is ${m1.size} and isMagic is ${m1.isMagic}")

    val m2=Mushroom(7,true)//create a mushroom by calling its primary constructor
    println("m2 size is ${m2.size} and isMagic is ${m2.isMagic}")

    println(addNumbers(2,5)) //call the int version of addMUmber
    print(addNumbers(1.6,7.3)) //call the DOUBLE VERSION OF aDD NUMBERS
 };  **/


data class Student(val firstName: String, val lastName: String,
                   val house: String, val year: Int = 1)
fun madoka(){
    val m1=Student("marsden","triming","hhddd")
    println(m1.firstName)

}

fun main(args: Array<String>) {

    val s1 = Student("Ron", "Weasley", "Gryffindor")
    val s2 = Student("Draco", "Malfoy", house = "Slytherin")
    val s3 = s1.copy(firstName = "Fred", year = 3)
    val s4 = s3.copy(firstName = "George")
    val array = arrayOf(s1, s2, s3, s4)

    for ((firstName, lastName, house, year) in array) {

        println("$firstName $lastName is in $house year $year")
    }
   val mad =madoka()
    println(mad)
}





/**
data class Movie(val title:String,val year:String)

class Song(val title: String,val artist:String)

fun main (args:Array<String>){
    var m1 = Movie("Black Panther","2018")
    var m2 = Movie("Jurassic World","2015")
    var m3 = Movie("Jurassic World","2015")

    var s1 =Song("Love Cats","The Cure")
    val s2=Song("wild horses","The building Stones")
    val s3=Song("Love Cats","The Cure")

    println(m2 == m3) //true because m1 and m2 are data objects
    println(s1 == s3)

    var m4 = m1.copy() //true because they have matching property values
    println(m1 == m4)

    var m5=m1.copy()
    println(m1 === m5) //separated objects hence false

    var m6=m2
    m2 = m3
    println(m3 === m6)
}

**/



//== checks for object equivalence.
//=== checks for object identity.

//var r1=recipe("THai curry",false)
//var r2=recipe(isVegetarian = true)

//data class Recipe(val title:String,val isVegetarian:Boolean)
//
//fun main(args:Array<String>){
//    val r1=Recipe("Thai curry",false)
//    val r2=Recipe("Thai curry",false)
//    val r3=r1.copy(title = "Chicken Bhuna")//create a copy of r1,altering its title property
//    println("r1 hash code: ${r1.hashCode()}")
//    println("r2 hash code: ${r2.hashCode()}")
//    println("r3 hash code: ${r3.hashCode()}")
//    println("r1 toString: ${r1.toString()}")
//    println("r1 == r2 is ${r1 == r2}") //==checks using the hashcode
//    println("r1 === r2 is ${r1 === r2}")//=== checks for object identity that is separate objects
//    println("r1 == r3 is ${r1 == r3}")
//    val(title,vegetarian)=r1 //destructure r1
//    println("title is $title and vegetation is $vegetarian")

//    When you define a data class, the compiler secretly overrides the
//    equals, hashCode and toString functions the class inherits so that they’re
//    more appropriate for objects whose main purpose is to hold data

//}