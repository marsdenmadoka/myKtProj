//   {X:Int->X+5}
//   fun addFive(x:Int)=x+5

//fun main(args:Array<String>){
//    var addFive={x:Int -> x+5} //this lambda adds 5 to an Int named x and the complier knows that x needs to be an int {x:Int} //The compiler can infer lambda parameter types
//    println("pass 6 to addFive; ${addFive(6)}")//here were saying or x is 6
//
//    val addInts={x:Int,y:Int -> x+y}//You invoke a lambda by calling its invoke function, passing in the values for any parameters here our lambda is adding ints
//    val result=addInts.invoke(6,7)
//    println("pass 6,7 to addInts: $result")
//
//    val intLamba: (Int,Int) -> Int={x,y->x*y}
//    println("pass 10,11 to intLambda: ${intLamba(10,11)}") //You can also invoke the lambda using this shortcut:
//
//    //val addSeven:(Int)-> Int={x:Int->x+7} //As the lambda has a single parameter, x, and the compiler can infer that x is an
//    //Int, we can omit the x parameter from the lambda, and replace it with (it) in the lambda body
//    val addSeven:(Int)-> Int = {it+7} //You can replace a single parameter with (it)
//    println("pass 12 to addSeven: ${addSeven(12)}")
//
//    val mylambda:()->Unit={println("Hi!")} //Use Unit to say a lambda has no return value
//    mylambda()
//}

fun convert(x:Double,converter:(Double)->Double):Double{
    val result=converter(x) //invokes the lambda named converter and assigns its return value to result
    println("$x is converted to $result")
    return result
}

fun convertFive(converter: (Int) -> Double) : Double {
    val result=converter(5)
    println("5 is converted to $result")
    return result
}


fun main(){
    convert(20.0){it * 1.8 + 32}
    convertFive { it * 1.8 + 32 }
}
