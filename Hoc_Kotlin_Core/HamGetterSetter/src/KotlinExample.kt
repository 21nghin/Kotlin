package hello

open class Person(open val firstName: String, val lastName: String, var age: Int?){
    // khởi tạo getter và setter
    private var fullName = "$firstName $lastName"

    open fun talk(message: String = ""){
        println("$fullName says $message")
    }

    var isAdult: Boolean
    get(){
        println("Prepare to get isAdult")
        if(age == null){
            return false
        }else if(age!! > 18){
            return true
        }
        return false
    }
    set(value){
        println("Prepare to set isAdult")
        age = if(value == true) 18 else null
    }

    // lateinit khởi tạo sau
    lateinit var language: String
}

class Engineer(fieldOfStudy: String, firstName: String, lastName: String, age: Int?): Person(firstName, lastName, age){
    override val firstName = super.firstName.toUpperCase()
    override fun talk(message: String){
        super.talk(message)
        println("I am engineer")
    }
}

fun main() {
    var engineer = Engineer("mechanics", "Hoang", "Nito", 25)
    engineer.talk("Good afternoon")
    println("Detail. FirstName = ${engineer.firstName}, lastName = ${engineer.lastName}, age = ${engineer.age}")
    //getters
    println("${engineer.firstName} is an adult ? ${engineer.isAdult}")
    //setter
    engineer.isAdult = false
    if(engineer.age == null){
        println("age is null")
    }
    engineer.language = "English"
    println("Detail. language = ${engineer.language}")
}