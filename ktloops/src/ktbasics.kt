//fun main(args:Array<String>) {
//    // var x :Int = 10
//    var x = 10
//    while(x > 1){
//       x =x-1
//        if(x<3) println("small x")
//    }
//
//}

//fun main(args:Array<String>) {
////    var message='hello'; var messages="hello";
//
//     var x :Int = 10
//    var y:Double=x.toDouble()
//
//        println("this is y $y")
//}


//fun main(args: Array<String>) {
//    val wordArray1 = arrayOf("24/7", "multi-tier", "B-to-B", "dynamic", "pervasive")
//    val wordArray2 = arrayOf("empowered", "leveraged", "aligned", "targeted")
//    val wordArray3 = arrayOf("process", "paradigm", "solution", "portal", "vision")
//
//    val arraySize1 = wordArray1.size
//    val arraySize2 = wordArray2.size
//    val arraySize3 = wordArray3.size
////generates a random number. Math.random() returns a random number between 0 and (almost) 1, so we have to multiply it by the number of items in the array.
////We then use toInt() to force the result to be an integer.
//
//    val rand1 = (Math.random() * arraySize1).toInt()
//    val rand2 = (Math.random() * arraySize2).toInt()
//    val rand3 = (Math.random() * arraySize3).toInt()
// //uses a String template to pick three words and put them together
//    val phrase = "${wordArray1[rand1]} ${wordArray2[rand2]} ${wordArray3[rand3]}"
//
//    println(phrase)
//}

//
//fun main(args:Array<String>){
//    val hobbits= arrayOf("Frodo","sam","merry","Pippin")
//    var x=0
//     while(x<4){
//         println("${hobbits[x]} is good")
//         x=x+1
//     }
//}

fun main(args:Array<String>){
    val hobbits= arrayOf("Frodo","sam","merry","Pippin")
    var x=0
     while(x<4){
         println("${hobbits[x]} is good")
         x=x+1
     }
}