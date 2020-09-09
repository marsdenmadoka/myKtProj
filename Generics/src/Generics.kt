abstract class Pet(var name:String)

class Cat(name:String):Pet(name) //this is a type of pet
class Dog(name:String):Pet(name) //this is a type of pet
class Fish(name:String):Pet(name) //this is a type of pet
class Vet<T:Pet>{
    fun treat(t:T){
        println("Treat pet ${t.name}")
    }
}

//using generics means that you can place limits on how a class uses its types,
//making your code much more consistent and robust.
class Contest<T:Pet>(var vet: Vet<in T>){//we are adding Vet(T to the contest constructor so that you cant create a contest without assigning a vet
//class Contest<T:Pet>{ //contest class with our generic type T
    val scores:MutableMap<T,Int> = mutableMapOf()//defines a mutable Map with T keys, and int values,where T is the generic type of Pet that the contest is dealing with
    fun addScore(t:T,score:Int=0){
        if(score >= 0) scores.put(t,score) //put the contestants and its score in the mutablemap,so long as the score is greater or equal to 0
    }
    fun getWinners(): MutableSet<T>{ //As each contestant has a generic type of T, the function must have a return type of MutableSet<T>.
        val highscore=scores.values.max() //get the highest value from scores
        val winners:MutableSet<T> = mutableSetOf()
        for((t,score)in scores){
            if(score==highscore) winners.add(t) //Add any contestant with the highest score to a mutableSet
        }
        return winners //return mutableSet of winners
    }
}
interface Retailer<out T>{ //In general, a class or interface generic type may be prefixed with out if the class //has functions that use it as a return type, or if the class has val properties of that type
  fun sell():T
}
class CatRetailer:Retailer<Cat>{
    override fun sell(): Cat{
        println("sell cat")
        return Cat("")
    }
}
class DogRetailer:Retailer<Dog>{
    override fun sell(): Dog{
        println("sell dog")
        return Dog("")
    }
}
class FishRetailer:Retailer<Fish>{
    override fun sell(): Fish{
        println("sell fish")
        return Fish("")
    }
}



fun main(args:Array<String>){
    val catFuzz=Cat("fuzz light")  //create two cats and a fish thise are types of pets
    val catkatsh=Cat("katsu")
    val fishFinny=Fish("tilapia")

     val catVet=Vet<Cat>()
    val fishVet=Vet<Fish>()
    val petVet=Vet<Pet>()

    catVet.treat(catFuzz)
    petVet.treat(catkatsh)
    petVet.treat(fishFinny)


    val catContest=Contest<Cat>(catVet) //Hold a Cat contest(Cats-only) these are types of contest
    //val catContest=Contest<Cat>
    catContest.addScore(catFuzz,50) //And as Contest uses generics, the compiler prevents you from passing any non- Cat references to it eg the fishFinny
    catContest.addScore(catkatsh,45)
    val topCat=catContest.getWinners().first()
    println("cat contest winner is ${topCat.name}")

    val petContest=Contest<Pet>(petVet) //Hold a Pet Contest,that will accept all types of Pet
    //val petContest=Contest<Pet>
    petContest.addScore(catFuzz,50) //Pet is the superType therefore it can hold any type of pets
    petContest.addScore(fishFinny,56)
    val topPet=petContest.getWinners().first()
    println("pet contest winner is ${topPet.name}")

    val fishContest=Contest<Fish>(petVet) //assign a vet<Pet> to a contest
    //retailer objects
    val dogRetailer:Retailer<Dog> = DogRetailer()
    val catRetailer:Retailer<Cat> = CatRetailer()
    val petRetailer:Retailer<Pet> = CatRetailer() //remember the interface Retailer<out T>
    dogRetailer.sell()
    catRetailer.sell()
    petRetailer.sell()

}
