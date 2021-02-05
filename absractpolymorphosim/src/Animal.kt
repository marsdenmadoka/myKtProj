//you implement abstract properties and functions by overriding them.
// This is the same as if the superclass was concrete

interface Roamable{ //An interface lets you define common behavior OUTSIDE a superclass hierarchy
    fun roam()  //With an interface, the compiler automatically infers that a function with no body must be abstract, so you don’thave to mark it as such.
}
/**
interface Roamble{
    var velocity:Int
    get() = 20
    set(value) {
        println("Unable to update velocity")
    }
}
**/
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

//If the class that implements the interface is abstract, however, the class can either implement the properties and
//functions itself, or pass the buck to its subclasses.

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
 class Vehicle : Roamable{ //implements from an interface //the vehicle is not a subclass of animal niether a super of any of the animal subclass
     override fun roam() { //this from our interface
         println("the vehicle is roaming")
     }
      fun drive() { //this from our interface
         println("am driving my vehice")
     }
 }

fun main(args:Array<String>){
    val myarray= arrayOf(Hippo(),Wolf(),Vehicle()) //polymorphic arrays
    for (item in myarray){
        item.roam() //our roam is both in vehicle class and Animal class therefore we need not to use the if statament
      // item.eat() //uncomment this and sees what happens when you remove the VEHICLE from our Array and when its there..note the working
        // item.makeNoise()
        if (item is Animal){ //NOTE//the Animal class has no relationship/it is not a super or subclass of Vehicle therefore we must specify where our
           //]]if (item is Wolf){ } //wolf is a subclass of Animal it must be included inside here
            item.eat()   //function eat and make noise come from/belong since there ONLY in the Animal class
             item.makeNoise() //roam is taken from our interface and is everywhere hence no need of if statement..refer page 313-316
        }
        if (item is Vehicle){
            item.drive()
        }
    }

val vet = Vet()
val wolf=Wolf()
val hippo=Hippo()

vet.giveShot(wolf)//polymorphism.
vet.giveShot(hippo)//polymorphism.
};

//when(myarray){
//    is Wolf ->{
//       //wolf specific code
//    }
//    is Hippo ->{
//  //Hippo specific code
//    }
//    is Animal ->{
//   //ANimal specif code
//    }
//}

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
 * If a class inherits multiple implementations of the same function or property, the
*class must provide its own implementation, or specify which version of the function or property it should use

interface A{
    fun myFunction(){ println("from A")}
}
interface B{
    fun myFunction(){ println("from B")}
}
 class X:A,B{
     override fun myFunction() {
         super<A>.myFunction()//super<A>.myFunction() refers to the superclass(or interface) named A.So Super<A>myFUNction calls the version of myFUnction thats defined in interface A
        super<A>.myFunction()
     }
 }

**/


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