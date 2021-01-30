
/**
fun main(args: Array<String>){
 printSum(5,6)
}
fun printSum(int1: Int, int2: Int) { // two-parameter function, and sending it two  arguments
val result=int1+int2
println(result)
}
**/


/**
fun main(args: Array<String>){
    val x=7
    val y=8
  printSum(x,y)
}
fun printSum(int1: Int, int2: Int) {  // two-parameter function, and sending it two  arguments
    val result=int1+int2
    println(result)
}
**/

/**fun max(a:Int,b:Int):Int{ //The Int tell the compiler the function returns an Int value ....If you want to get something back from a function, you need to declare it.
    val maxValue=if(a>b) a else b
    return maxValue //you return a value using the return keyword
} **/
/**
fun main(args: Array<String>){
    var x = 0
    var y = 20
    for (outer in 1..3){
       for (inner in 4 downTo 2){
          x+=6
           y++
           x += 3
       }
        y-=2
    }
    println("$x $y")
}
**/
//for (x in 1..100) println(x) //this code prints numbers from 1-100
//for(x in 15 downTo  1) println(x)//this code prints range of numbers in reverse order from 15-1
//for (x in 1..100 step 2) println(x) //prints range of no from 1-100 while skipping 2 numbers

fun main(args:Array<String>){
    val options= arrayOf("Rock","Paper","Scissors")
    val gameChoice = getGameChoice(options) //The getGameChoice function selects one of the optionsParam’s items at random
    val userChoice=getUserChoice(options) //getting the users choice from the options
    printResult(userChoice ,gameChoice)//call the printResut function
}

fun getGameChoice(myOptions:Array<String>)=
    myOptions[(Math.random()* myOptions.size).toInt()] //getting random option from the array


fun getUserChoice(optionsParam: Array<String>): String { //getting the user choice

    var isValidChoice=false;//will use this to indiate whether the user has entered a valid choice
    var userChoice = " "

     while (!isValidChoice){ //keep looping untill isvalid choice is true
    print("please enter one of the following::")
    for (item in optionsParam) print(" $item") //loop through the array and print all the values
    println(".")
    //read the users input
    val userInput = readLine()
    //validate user input
    if(userInput !=null && userInput in optionsParam){ //check that the user input isnt null, and that its in the options array
        isValidChoice=true //if the user input is ok,we can stop looping
        userChoice=userInput
    }
    //if choice is invalid,inform the user
    if(!isValidChoice) println("you must enter a valid a choice")
     }

    return  userChoice //we return the userChoice that he has entered
}
//printing the results
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