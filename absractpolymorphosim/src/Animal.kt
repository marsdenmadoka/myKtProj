//you implement abstract properties and functions by overriding them.
// This is the same as if the superclass was concrete

interface Roamable{
    fun roam()
}
//we declare a class to be a supper class by calling it open
//To use a class as a superclass, it must be declared as open. Everything you want to override must also be open.
abstract class Animal:Roamable{ //when we call it abstract we don't need to declared it open abstract class can’t be instantiated .
    abstract val image:String
    abstract val food:String
    abstract val habitat:String
    var hunger=10


    abstract fun makeNoise()//abstract functions have no function bodies.
    abstract fun eat()//If you put even one abstract property or function in a class, you have to mark the class as abstract or your code won’t compile.

    override fun roam(){ //fetching this from our interface
        println("The animal is roaming")
    }
    fun sleep(){
        println("The Animal is sleeping")
    }
}


class Hippo : Animal(){ //The first concrete class in the inheritance tree below the abstract superclass
                      // must implement all abstract methods and properties in from our Supper class
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
//You override a property that’s been inherited from a superclass by adding the
//property to the subclass, and prefixing it with the override keyword.
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
    fun giveShot(animal:Animal){//polymorphism........... Being able to use one type of object in a place that explicitly expects a different type is called polymorphism. It’s the ability to provide different
                                //implementations for functions that have been inherited from somewhere else.
        animal.makeNoise()
    }
}
 class Vehicle : Roamable{ //implements from an interface
     override fun roam() { //this from our interface
         println("the vehicle is roaming")
     }
 }

fun main(args:Array<String>){
    val animals= arrayOf(Hippo(),Wolf(),Vehicle()) //polymorphic arrays
    for (item in animals){
        item.roam()
      // item.eat() //uncomment this and sees what happens when you remove the Vehicle from our Array and when its there..note the working
        if (item is Animal){ //understand this line well, since we included in oour arrray above a class that inherited from our interfce
            item.eat()   //and not our super class..we must use this to tell where eat function came from our supper class
                        //roam is taken from our interface and is everyone hence no need of if stateme..refer page 313-316
        }
    }

val vet = Vet()
val wolf=Wolf()
val hippo=Hippo()

vet.giveShot(wolf)//polymorphism.
vet.giveShot(hippo)//polymorphism.
}

//An interface lets you define common behavior OUTSIDE a superclass hierarchy
//You mark that a class implements an interface in a similar way to how you mark
//that a class inherits from a superclass: by adding a colon to the class header
//followed by the name of the interface but you don't put () parentesis after the interface name

//class X:A,B //class X implements from intercae A and B
//class Y:C(),A //class Y inherits from C and implements A
//Interfaces let you use polymorphism

//the function or property stays open in each of its subclasses, even if it’s overridden,
//Being able to use one type of object in a place that explicitly expects a different type is called polymorphism.
//It’s the ability to provide different implementations for functions that have been inherited from somewhere else.

/**
 * if the superclass has a
primary constructor, then you must call it in the subclass header or your
code won’t compile.
 * supper class with constructor example
  open class Car(val make:String,val model:String){
 //Code for the Car class the car constructor defines two properties make and model
 }
 Class ConvertableCar(make_param:String,
model_param:String):Car(make_param,model_param){
//code for the convertibale car class
}
 //When you override a function, there are two rules that you must follow:
//* The function parameters in the subclass must match those in the
//superclass.
//So if, for example, a function in the superclass takes three Int
//arguments, the overridden function in the subclass must also take three
//Int arguments or the code won’t compile.
//* The function return types must be compatible.
//Whatever the superclass function declares as a return type, the
//overriding function must return either the same type, or a subclass type.
//A subclass type is guaranteed to do anything its superclass declares, so
//it’s safe to return a subclass where the superclass is expected.
 //
 **/