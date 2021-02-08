//**
abstract class Pet(var name:String)

class Cat(name:String):Pet(name) //this is a type of pet
class Dog(name:String):Pet(name) //this is a type of pet
class Fish(name:String):Pet(name) //this is a type of pet


//must be a type of Pet so that you can’t create a Vet that treats,
class Vet<T:Pet>{ //vets can specialize in treating different types of pet
    fun treat(t:T){//pass the contestant to the function as parameter value;
        println("Treat pet ${t.name}")
    }
}

//using generics means that you can place limits on how a class uses its types,
//making your code much more consistent and robust.
//Assign a Vet to a Contest
//Use in to make a generic type contravariant--we want to be able to use a generic supertype in place of a generic subtype.
class Contest<T:Pet> (var vet: Vet<in T>){//T is contravariant but only in the contest constructor since it was added in the Contest constructor//contest class with our generic type T,T is a generic type that must be Pet or one of its subtypes

    //each contestant is an object of type T and each score is an Int
    val scores:MutableMap<T,Int> = mutableMapOf()//The scores property needs to keep track of which contestant receives which score.
                                                // We’ll therefore use a MutableMap, with contestants as keys, and their scores as values
    fun addScore(t:T,score:Int=0){ //pass the contestant and score to the function as parameter values;
        if(score >= 0) scores.put(t,score) //put the contestants and its score in the mutablemap,so long as the score is greater or equal to 0
    }
    fun getWinners(): MutableSet<T>{ //As each contestant has a generic type of T, the function must have a return type of MutableSet<T>.
        val highscore=scores.values.max() //get the value of the highest score from the scores property
        val winners:MutableSet<T> = mutableSetOf()
        for((t,score)in scores){//return all contestants(t) with the highscore in a MutableSet.
            if(score==highscore) winners.add(t) //Add any contestant with the highest score to a mutableSet winners
        }
        return winners //return mutableSet of winners
    }
}
//Use out to make a generic type covariant-If you want to be able to use a generic subtype object in a place of a generic supertype,
//If a generic type is covariant, it means that you can use a subtype in place of a supertype
interface Retailer<out T>{ //The Retailer interface needs to specify that it uses a generic type T, which is used as the return type for the sell function.
  fun sell():T
}

//retailers that can sell different types of pet
//The CatRetailer class implements the Retailer interface so that it can deal with Cats.this means the sell function must return a cat
class CatRetailer:Retailer<Cat>{
    override fun sell(): Cat{
        println("sell cat")
        return Cat("")
    }
}


class DogRetailer:Retailer<Dog>{//The DogRetailer replaces  Retailer generic type with Dog so it sells function must return a Dog
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
    val fishFinny=Fish("finny tilapia")

      //create some Vet objects
     val catVet=Vet<Cat>()
    val fishVet=Vet<Fish>()
    val petVet=Vet<Pet>()

    //get the vets to treat some Pets
    catVet.treat(catFuzz)
    petVet.treat(catkatsh)
    petVet.treat(fishFinny)



    val catContest=Contest<Cat>(catVet) //Hold a Cat contest(Cats-only) these are types of contest

    //val catContest=Contest<Cat>
    catContest.addScore(catFuzz,50) //And as Contest uses generics, the compiler prevents you from passing any non- Cat references to it eg the fishFinny
    catContest.addScore(catkatsh,45)
    val topCat=catContest.getWinners().first()
    println("cat contest winner is ${topCat.name}")

    //assign a Vet<Pet> to the Contest <pet> //use of contravariance,
    val petContest=Contest<Pet>(petVet) //Hold a Pet Contest,that will accept all types of Pet

    //val petContest=Contest<Pet>
    petContest.addScore(catFuzz,50) //Pet is the superType therefore it can hold any type of pets
    petContest.addScore(fishFinny,56)
    val topPet=petContest.getWinners().first()
    println("pet contest winner is ${topPet.name}")

     //assign a Vet<Fish> to the Contest <fish> contravariance //USE OF  CONTRAVARIANCE
    val fishContest=Contest<Fish>(petVet) //assign a vet<Pet> to a contest //USE OF  CONTRAVARIANCE


    //retailer objects
    val dogRetailer:Retailer<Dog> = DogRetailer()
    val catRetailer:Retailer<Cat> = CatRetailer()
    val petRetailer:Retailer<Pet> = CatRetailer() //remember the interface Retailer<out T>//USE OF COVARIANT
    dogRetailer.sell()
    catRetailer.sell()
    petRetailer.sell()

}
//**/




//In general, a class or interface generic type may be prefixed with out if the class has functions that use it as a return type, or if the
//class has val properties of thattype. You can’t, however, use out if the class has function parameters or var properties of that generic type.
//N/B--covariant type  cant be used as a function parameter can only be used as a return type
//    --covariant type cant be used as type of a var property

//In general, a class or interface generic type may be prefixed with in if the class has functions that use it as a parameter type. You can’t, however, use in if any
//of the class functions use it as a return type, or if that type is used by any properties, irrespective of whether they’re defined using val or var.
//N/B -- a contravariance cant be used as a return type
//     --type cant be used as type of a var property

/**
abstract class Pet(var name:String)

class Cat(name:String):Pet(name) //this is a type of pet
class Dog(name:String):Pet(name) //this is a type of pet
class Fish(name:String):Pet(name) //this is a type of pet

//using generics means that you can place limits on how a class uses its types,
//making your code much more consistent and robust.

   class Contest<T:Pet>{//we are adding Vet(T to the contest constructor so that you cant create a contest without assigning a vet
//class Contest<T:Pet>{ //contest class with our generic type T,T is a generic type that must be Pet or one of its subtypes

//each contestant is an object of type T and each score is an Int
     val scores:MutableMap<T,Int> = mutableMapOf()//The scores property needs to keep track of which contestant receives which score.
// We’ll therefore use a MutableMap, with contestants as keys, and their scores as values

    fun addScore(t:T,score:Int=0){ //pass the contestant and score to the function as parameter values;
    if(score >= 0) scores.put(t,score) //put the contestants and its score in the mutablemap,so long as the score is greater or equal to 0
      }

    fun getWinners(): MutableSet<T>{ //As each contestant has a generic type of T, the function must have a return type of MutableSet<T>.
        val highscore=scores.values.max() //get the value of the highest score from the scores property
        val winners:MutableSet<T> = mutableSetOf()

        for((t,score)in scores){//return all contestants(t) with the highscore in a MutableSet.
        if(score==highscore) winners.add(t) //Add any contestant with the highest score to a mutableSet winners
           }
        return winners //return mutableSet of winners
    }


}

fun main(args:Array<String>){

    val catFuzz=Cat("fuzz light")  //create two cats and a fish thise are types of pets
    val catkatsh=Cat("katsu")
    val fishFinny=Fish("finny tilapia")

    val catContest=Contest<Cat>()
    catContest.addScore(catFuzz,50) //And as Contest uses generics, the compiler prevents you from passing any non- Cat references to it eg the fishFinny
    catContest.addScore(catkatsh,45)
    val topCat=catContest.getWinners().first()
    println("cat contest winner is ${topCat.name}")

    val petContest=Contest<Pet>()
    petContest.addScore(catFuzz,50) //Pet is the superType therefore it can hold any type of pets
    petContest.addScore(fishFinny,56)
    val topPet=petContest.getWinners().first()
    println("pet contest winner is ${topPet.name}")

}
 **/




