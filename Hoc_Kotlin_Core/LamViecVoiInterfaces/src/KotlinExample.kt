package hello

class ConDoi: ConVatInterface, ConChimInterface{
    override fun walk() {
        super.walk()
        println("Tôi là một con dơi. tôi có thể đi bộ")
    }

    override fun fly() {
        super.fly()
        println("Tôi là một con chim. Tôi có thể bay")
    }

    override fun eat() {
        super<ConChimInterface>.eat()
        super<ConVatInterface>.eat()
        // làm gì ở đây
    }

}

fun main() {
    var bat: ConDoi = ConDoi()
    bat.walk()
    println("=========//=========")
    bat.fly()
    println("=========//=========")
    bat.eat()
}

// Lưu ý: Chia interface rất thuận tiện khi có Object có nhiều method chia ra để thực thi cho dễ