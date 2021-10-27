package hello

// Delegation là gì: Là uỷ quyền trao quyền cho người khác thực hiện phương thức đó hộ chúng
// Tất nhiên chúng ta có thể thực hiện được phương thức đó
// ví sạu sau để thực hiện Delegation

interface BirdInterface{
    fun flyAndFindFood()
}

class Eagle(val age: Int) : BirdInterface{
    override fun flyAndFindFood() {
        println("Tôi là một con chim ưng. Tôi $age tuổi. Tôi đang bay và tìm thức ăn")
    }

}

class Cuckoo(b: BirdInterface): BirdInterface by b{ // khai báo class kiểu thực hiện hộ
    // bỏ comment phương thức dưới bản thân nó sẽ tự chạy phương thức đó
    override fun flyAndFindFood() {
        println("Tôi là một con chim Cockoo. Tôi đang bay và tìm thức ăn")
    }
}

fun main() {
    val eagle = Eagle(2)
    eagle.flyAndFindFood()

    // sử dụng tên khai báo của class Eagle trước đó thực hiện phương thức hộ chúng
    var cuckoo = Cuckoo(eagle)
    cuckoo.flyAndFindFood()
}