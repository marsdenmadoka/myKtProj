//Before a class can be used as a superclass, you have to explicitly tell the
//compiler that this is allowed. You do this by prefixing the name of the class—
//and any properties or functions you want to override—with the keyword open.
//This tells the compiler that you’ve designed the class to be a superclass, and that
//you’re happy for the properties and functions you’ve declared as open to be
//overridden.
open  class Animal{ //To use a class as a superclass, it must be declared as open. Everything you want to override must also be open.
    open val image=""
    open val food=""
    open val habitat=""
    var huner=10

    open fun makeNoise(){
        println("The animal is making noise")
    }
    open fun eat(){
        println("The Animal is eating")
    }
    open fun roam(){
        println("The animal is roaming")
    }

    fun sleep(){
        println("The animal is sleeping")
    }

}

//To make a class inherit from another, you add a colon (:) to the class header
//followed by the name of the superclass.

class Hippo : Animal(){ //inheritance
    override val image="hippopic"
    override val food="grass"
    override val habitat="water"


    override fun makeNoise() {
        println("grunt! grunt! grunt!")
    }

    override fun eat(){
        println("the hippo id eating $food")
    }
}

  open class Canine:Animal() { //inheritance

    override fun roam() {
        println("the canine is roaming")
    }

}

    class Wolf:Canine(){ //inheritance
        override val image="wolf"
        override val food="meat"
        override val habitat="forests"

        override fun makeNoise() {
          println("Hoooowww")
        }



        override fun eat(){
            println("the wolf eats $food")
        }

    }


class Vet{
    fun giveShot(animal: Animal){ //starting polymorphism
        animal.makeNoise()
    }
}

fun main(args:Array<String>){
    val animals= arrayOf(Hippo(),Wolf()) //create an array of different Animal objects
    for(item in animals){ //Each Animal in the array responds in its own way
        item.roam()
        item.eat()
    }
       val vet = Vet()
       val wolf = Wolf()
       val hippo=Hippo()
       vet.giveShot(wolf) //impelementing polymorphism
       vet.giveShot(hippo) //polymorphism


//    Polymorphism is the ability to use any subtype(subclass) object in place of its
//    supertype(super class). As different subclasses can have different implementations of the
//    same function, it allows each object to respond to function calls in the way
//    that’s most appropriate for each object.


}




