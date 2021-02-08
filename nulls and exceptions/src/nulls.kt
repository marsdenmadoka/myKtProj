class Wolf{
    var hunger=10
    val food="meat"

    fun eat(){
        println("The wolf is eating $food")
    }
}
class MyWolf{
    var wolf:Wolf?=Wolf()

    fun myFuntion(){
        wolf?.eat()
    }
}

fun getAlphaWolf():Wolf?{
    return Wolf()
}


fun main(args:Array<String>){
    var w:Wolf?=Wolf()
    if(w != null){
        w.eat()
    }

    var y = w?.hunger ?: -1 //use the elvis operator to set y to the value of hunger if w is not  null.if w is null,it sets y to -1
    println("The value of y is $y")

     var myWolf=MyWolf()
    myWolf?.wolf?.hunger= 8
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    var myArray = arrayOf("Hi","Hello",null)
    for (item in myArray){
        item?.let { println(it) } //this prints the non-null items in the array
    }

    getAlphaWolf()?.let{it.eat()}

    w=null
  //  var z=w!!.hunger //this will throw a nullpointer eception as w is null
}









/**
class Cat(var name:String? = ""){
    fun Meow(){ println("Meow!")}
}
 fun main(args:Array<String>){
     var myCats = arrayOf(Cat("Misty"),null,Cat("Socks"))

     for (cat in myCats){
         if(cat != null){
             print("${cat.name}:")
             cat.Meow()
         }
     }
 }
**/
/**
fun getAlphaWolf():Wolf?{
    return Wolf()
}
 getAlphaWolf()?.let{ //using let is more concise. Its also safe,
                      //so you can use it in all situations
    it.eat()
}
**/
//W?.let{
//   println(it.hunger) //if w is not null,lets print its hunger
//}

//w?.hunger = 6 //It’s like saying “if myWolf is not null, and myWolf’s w property value is not null,
//then assign a value of 2 to w’s hunger property”:

//myWolf?.W?.hunger //if myWolf is not null,and w is not null,get hunger.Otherwise,use null //If myWolf is null, the entire expression evaluates to null
//Provided myWolf is not null, the system moves on to the next part of the expression, the w? part. If w is null, the entire expression evaluates to null
//w.eat() the ? means that eat() is only called if w is not null.