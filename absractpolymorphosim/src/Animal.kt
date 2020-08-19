//you implement abstract properties and functions by overriding them.
// This is the same as if the superclass was concrete

interface Roamable{
    fun roam()
}
abstract class Animal:Roamable{ //when we call it abstract we don't need to declared it open
    abstract val image:String
    abstract val food:String
    abstract val habitat:String
    var hunger=10


    abstract fun makeNoise()
    abstract fun eat()

    override fun roam(){ //fetching this from our interface
        println("The animal is roaming")
    }
    fun sleep(){
        println("The Animal is sleeping")
    }
}


class Hippo : Animal(){ //we must implement all abstract methods and properties in from our Supper class
    override val image="hippo"
    override val food="fisss"
    override val habitat="water"

    override fun makeNoise() {
      println("grunt!! grunt!!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }

}
abstract class Canine : Animal(){ //if we declare it abstract then we don't have to implement the superClass methods
    override fun roam(){
        println("The canine is roaming")
    }
}

class Wolf : Canine(){

    override val image="wolf"
    override val food="meat"
    override val habitat="forest"

    override fun makeNoise() {
        println("woow!! wow! wow!")
    }

    override fun eat() {
        println("The wolf is eating $food")
    }
}
class Vet{
    fun giveShot(animal:Animal){
        animal.makeNoise()
    }
}
 class Vehicle : Roamable{
     override fun roam() { //this from our interface
         println("the vehicle is roaming")
     }
 }

fun main(args:Array<String>){
    val animals= arrayOf(Hippo(),Wolf(),Vehicle())
    for (item in animals){
        item.roam()
        if (item is Animal){ //understand this line well, since we included in oour arrray above a class that inherited from our interfce
            item.eat()   //and not our super class..we must use this to tell where eat function came from our supper class
                        //roam is taken from our interface and is everyone hence no need of if stateme..refer page 313-316
        }
    }
val vet = Vet()
val wolf=Wolf()
val hippo=Hippo()
vet.giveShot(wolf)
vet.giveShot(hippo)
}

//An interface lets you define common behavior OUTSIDE a superclass hierarchy
//You mark that a class implements an interface in a similar way to how you mark
//that a class inherits from a superclass: by adding a colon to the class header
//followed by the name of the interface but you don't put () parentesis after the interface name

//class X:A,B //class X implements from intercae A and B
//class Y:C(),A //class Y inherits from C and implements A
//Interfaces let you use polymorphism