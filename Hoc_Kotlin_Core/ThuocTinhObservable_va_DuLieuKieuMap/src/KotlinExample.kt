package hello

import kotlin.properties.Delegates

class User(name: String) {
    var currentAddress: String by Delegates.observable("no address") // Cái này nghĩa là khi mà thuộc tính thay đổi thì nó sẽ chui vào 1 cái cho chúng ta thực thi
    {
        // khối lệnh trong  chạy khi cái thuộc tính  nó thay đổi
        // có biểu thức hàm lambda sau
        prop, oldAddress, newAddress -> run {
        // prop chính là các cái property của mình (oldAddress, newAddress là 2 cái giá trị  và giá trị cũ)
        // trong này sẽ in ra các giá trị nếu chung ta cần thay đổi
            println("Address is changing")
            println("From $oldAddress -> $newAddress")
            println("property's name = ${prop.name}")
        }
    }
}

//  Map là nơi để chứa các cặp dữ liệu key và value
var userObject = mutableMapOf<String, Any?>(
    "name" to "Tohn",
    "age" to 35,
) // tạo ra map để thay đổi được giá trị bên trong thêm là mutable (có thể thay đổi)

fun main() {
    //observable
    val user = User("Tohn")
    user.currentAddress = "1234 Penn Avenue\n" +
            "Pittsburgh, PA 15206\n" +
            "United States"
    user.currentAddress = "Bach Mai street, Hanoi, Vietnam"

    // Map để lấy ra được 1 giá trị nào đấy chúng ta dùng getValue() như sau
    println("User's details. Name = ${userObject.getValue("name")}, age = ${userObject.getValue("age")}")
    // nếu chúng ta muốn  chúng ta sẽ sử dụng hàm "set()"
    userObject.set("age", 40) // set key là age value là 40
    println("User's details. Name = ${userObject.getValue("name")}, age = ${userObject.getValue("age")}")

    // Thực thi gọi Map class như sau
    // newTableMap th thì nó thay đổi được giá trị
    // còn  mapOf thì chúng ta không thay đổi được key mới
    // cái này rất là hay khi mà chúng ta lấy giá trị từ Json request ở đâu  nó thuộc key và value
    val customer = Customer(mapOf(
        "name" to "John Lasseter",
        "age" to 30,
    ))
    println("Customer's details.Name = ${customer.name}, age = ${customer.age}")
}

// Dùng Map làm thuộc tính của 1 class chúng ta làm như sau
class Customer(val mapObject: Map<String, Any?>){
    val name: String by mapObject
    val age: Int? by mapObject
}