
//Before you can use a class as a superclass, you must declare it open.You must also declare any
// properties and functions you want to override as open.
open class Animal{
    open val image = ""
    open val food = ""
    open val habitat=""
    var hunger =10

    open fun makeNoise(){
        println("The Animal is making a noise")
    }

    open fun eat(){
        println("The Animal is eating")
    }
    open fun roam(){
        println("The Animal is roaming")
    }

    fun sleep(){
        println("The animal is sleeping")
    }
}

class Hippo:Animal(){
    override val image="hippo.jpg"
    override  val food = "grass"
    override val habitat="water"

override fun makeNoise(){
    println("Grunt Grunt")
}
override fun eat(){
    println("The Hippo is eating $food")
   }
}
   open class Canine:Animal(){
     override fun roam(){
         println("The Canine is roaming")
     }
   }


    class Wolf:Canine(){
        override val image="wolf.jpg"
        override val food = "meat"
        override val habitat = "forests"

        override fun makeNoise() { //the makeNoise function is not in the superclass of wolf i.e canine but since canine inheritis from animal which
            //has the function makeNoise  class wolf searhes throug the ihheritance tree to get the function makeNoise in Animal class
            println("Hooooww!!")
            //super.makeNoise() //this make the function to do what the super class is doing without any changes
        }

        override  fun eat(){
            println("The wolf is eating $food")
        }
    }

    class Vet{ //polymorphism........... Being able to use one type of object in a place that explicitly expects a different type is called polymorphism. It’s the ability to provide different
        fun giveShot (animal: Animal){  //implementations for functions that have been inherited from somewhere else.
            animal.makeNoise()
        }
    }


fun main(args:Array<String>){
    val animals= arrayOf(Hippo(),Wolf())
    for (item in animals){
        item.roam()
        item.eat()
        item.makeNoise() }

    val vet=Vet()
    val wolf=Wolf()
    val hippo=Hippo()
    vet.giveShot(wolf) //polymorphism.
    vet.giveShot(hippo) //polymorphism.

    }
//If the superclass has a primary constructor, then you must call it in  the subclass header.


