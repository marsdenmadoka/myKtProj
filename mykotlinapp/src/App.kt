
fun main(args:Array<String>){
    val options= arrayOf("Rock", "paper", "scissors")
    val gameChoice=getGameChoice(options)
    val userChoice=getUserChoice(options) //rember we did a paramerized function where our parameter was an array therefore we must call it
printResult(userChoice,gameChoice)//call the printResut function
//    for (x in 1..100) println(x)
//    for (x in 1 until 100) println(x)
}

fun getGameChoice(optionsParam:Array<String>)=
        optionsParam[(Math.random()*optionsParam.size).toInt()]


fun getUserChoice(optionsParam: Array<String>):String{
   var isValidChoice=false;
    var userChoice=""
    //loop until the user enters a valid choice
    while(!isValidChoice){ //keep looping until is valid choice is true
        //ask user for their choice
        print("Please enter one of the following:")
        for(item in optionsParam) print(" $item")
        println(".")
        //read the user input
        val userInput = readLine()
        //validate the user input
        if(userInput != null && userInput in optionsParam){ //check that the user input isn't null and that its in the options array
            isValidChoice=true //if the user input is okay we can stop looping
            userChoice=userInput
        }
        //if the choice is invalid inform te user
        if(!isValidChoice)
            println("you must enter a valid choice ")

    }
   return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
//Figure out the result
    if (userChoice == gameChoice) result = "Tie!" //if the user and the game chose the same option,the result is a tie
      //if any of these commbos are true the user wins
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
            (userChoice == "Paper" && gameChoice == "Rock") ||
            (userChoice == "Scissors" && gameChoice == "Paper"))
        result = "you win!!"
    else result = "you lose!"
    //print the results
    println("you chose $userChoice. i chose $gameChoice.$result")
}


//if (price <= 10 || price >= 1000) {
////Phone is too cheap or too expensive
//}
//if (price >= 200 && price <= 300) {
////Code to choose the phone
//}
//if ((price <= 500 && memory >= 16) ||
//(price <= 750 && memory >= 32) ||
//(price <= 1000 && memory >= 64)) {
////Do something appropriate
//}



//fun main(args: Array<String>) {
//    val options = arrayOf("Rock", "Paper", "Scissors","welcm")
//    updateArray(options)
//    println(options[2])
//}
//fun updateArray(optionsParam: Array<String>) {
//    optionsParam[2] = "Fred"
//}


//calling a two parameter function
//fun main(){
//    printSum(5,6)
//}
// fun printSum(int1:Int,int2:Int){
//     val result =int1+int2
//     println(result)
// }

//calling a two parameter function
//fun main(){
//val x:Int=7
//val y:Int=8
//    printSum(x,y)
//}
// fun printSum(int1:Int,int2:Int){
//     val result =int1+int2
//     println(result)
// }

//function named max returns an Int value:
// fun max(a:Int,b:Int):Int{
//    val maxValue=if(a>b) a else b
//        return maxValue
//}

//fun main(){
//    val hobbits= arrayOf("frodo","sam","merry","Pippin")
//    var x=0;
//    while(x<4){
//        println("${hobbits[x]} is a good name")
//        x=x+1
//    }
//}
//
//fun main(args: Array<String>) {
//    val wordArray1 = arrayOf("24/7", "multi-tier", "B-to-B", "dynamic", "pervasive")
//    val wordArray2 = arrayOf("empowered", "leveraged", "aligned", "targeted")
//    val wordArray3 = arrayOf("process", "paradigm", "solution", "portal", "vision")
//    val arraySize1 = wordArray1.size
//    val arraySize2 = wordArray2.size
//    val arraySize3 = wordArray3.size
////
////    for(item in wordArray1){ //using for loops in arrays
////        println("$item")
////    }
////
////    for((index,item) in wordArray1.withIndex()){ //loppoing through the array with index
////        println("$index $item")
////    }
//
//    val rand1 = (Math.random() * arraySize1).toInt()
//    val rand2 = (Math.random() * arraySize2).toInt()
//    val rand3 = (Math.random() * arraySize3).toInt()
//
//    val phrase = "${wordArray1[rand1]} ${wordArray2[rand2]} ${wordArray3[rand3]}"
//    //To include the value of a variable inside a String, you prefix the variable name with a $
//    var result = "myArray is ${if (wordArray1.size > 10) "large" else "small"}"
//
//    println(result)
//    println(phrase)
//}




//fun main(){
//    var x= 0;
//    var y=0
//    while(x<5){
//      if(y<5){
//          x=x+1
//          if(y<3)
//              x=x-1
//      }
//        y=y+3
//        println("$x$y")
//        x=x+1
//    }
//}

//var x=5
//var z: Long=x.toLong()

//fun main(){
//    var x=10
//    while(x>3){
//        x = x - 1
//        if(x<8) println("small x:$x")
//
//    }
//}


//fun main(){
//    val x=3
//    val y=1
//
//    println(if(x>y) "x is greater than y" else "x is not greater than y")
//    println("this lie runss no matter what")
//}



//fun main (){
////    print("HELP ME GOD jjjjjj")
//    var x = 1;
//    println("before the loop. x=$x.")
//     while(x>4) {
//        println("in the loop. x = $x");
//        x=x+1
//    }
//
//}
