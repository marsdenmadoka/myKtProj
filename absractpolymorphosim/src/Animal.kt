//you implement abstract properties and functions by overriding them.
// This is the same as if the superclass was concrete
abstract class Animal(){ //when we call it abstract we don't need to declared it open
    abstract val image:String
    abstract val food:String
    abstract val habitat:String
    var hunger=10


    abstract fun makeNoise()
    abstract fun eat()

    open fun roam(){
        println("The animal is roaming")
    }
    fun sleep(){
        println("The Animal is sleeing")
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