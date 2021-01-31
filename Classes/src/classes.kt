
class Rectangle(var width:Int,var height:Int){

    val isSquare:Boolean
        get()=(width == height) //getter that says whether a rectangle is square

    val area:Int
    get()=(width*height) //getter that calculates the rectangle area
}

fun main(array: Array<String>){

    val r= arrayOf(Rectangle(1,1),Rectangle(1,1),
            Rectangle(1,1),Rectangle(1,1))

    for(x in 0..3) { //the r array has 4 items,so will loop from index 0 to index 3
        r[x].width=(x+1) * 3 //set the width and height of the rectangle
        r[x].height=x+5
        print("Recatangle $x has area of ${r[x].area}")       //print rectangle area
        println(" it is ${if(r[x].isSquare) "" else "not"} a square") //print whether or not the rectangle is asquare
    }

}



/**
class Dog(val name: String,
          weight_param: Int,
          breed_param: String) {
    init {
        print("Dog $name has been created. ")
    }
    var activities = arrayOf("Walks")
    val breed = breed_param.toUpperCase()
    init {
        println("The breed is $breed.")
    }
    var weight = weight_param //setter
        set(value) {
            if (value > 0) field = value
        }
    val weightInKgs: Double //getter
        get() = weight / 2.2

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}

fun main(args: Array<String>) {
    val myDog = Dog("Fido", 70, "Mixed")
    myDog.bark()
    myDog.weight = 75
    println("Weight in Kgs is ${myDog.weightInKgs}")
    myDog.weight = -2
    println("Weight is ${myDog.weight}")
    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for (item in myDog.activities) {
        println("My dog enjoys $item")
    }
    val dogs = arrayOf(Dog("Kelpie", 20, "Westie"),
        Dog("Ripper", 10, "Poodle"))
    dogs[1].bark()
    dogs[1].weight = 15
    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")
}
**/


/**
class TapeDeck {
    var hasRecorder = false

    fun playTape() {
        println("Tape playing")
    }
    fun recordTape() {
        if (hasRecorder) {
            println ("Tape recording")
        }
    }
}
fun main(args: Array<String>) {
    var t = TapeDeck() //the () braces because our class didn't have a constructor
    t.hasRecorder = true
    t.playTape()
    t.recordTape()
}
**/
// lateinit var temperament: String ..the lateinit tells the compiler that you’re aware that the property hasn’t been initialized yet, and you’ll handle it later.

/**
class DVDPlayer(var hasRecorder:Boolean){
    fun playDVD(){
        println("DVD Playing")
    }
    fun recordDVD(){
        if(hasRecorder){
            println("DVD recording")
        }
    }
}
fun main(args:Array<String>){
    val d = DVDPlayer(true)
    d.playDVD()
    d.recordDVD()
}
**/



/**
class Song(val title:String,val artist:String){

    fun play(){
    println("playing the song $title by $artist")
    }

    fun stop(){
        println("Stopped playing $title")
    }

}

fun main(args:Array<String>){
    val songOne= Song("kigeugeu","jaguar")
    val songTwo = Song("fululix","madoka")
    val songThree = Song("wakakwaka","mark")
    songOne.play()
    songOne.stop()
    songTwo.play()
    songTwo.stop()
    songThree.play()
} //**/