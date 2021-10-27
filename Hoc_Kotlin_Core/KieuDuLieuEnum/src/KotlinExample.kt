
package hello

// Enum sử dụng khi liệt kê các giá  mà chúng ta cần 1 kiểu nào đấy có chứa 1 giá trị xác  và chỉ dùng cho giá trị đó

enum class CompassDirection{
    EAST,
    WEST,
    SOUTH,
    NORTH
}

// Enum với thông số đầu vào
enum class Color(val red: Int, val green: Int, val blue: Int){
    RED(255,0,0),
    GREEN(0,255,0),
    BLUE(0,0,255)
}

fun main() {
    println("North enum = ${CompassDirection.NORTH}")
    println(Color.BLUE.toString())
    println("Color detail.Name = ${Color.GREEN.name}, ordinal: ${Color.GREEN.ordinal}") // ordinal trả về thứ tự của hằng số liệt kê này (vị trí khao báo trong enum class, Trong đó hằng số khai báo ban đầu được gán thứ tự bằng 0 )
    // ValueOf đưa vào 1 gía trị kiểm tra có tồn tại hay không
    // Sử dụng valueOf như sau:
    println(Color.valueOf("BLUE")) // Nếu tồn tại thì nó trả về đúng giá trị đó còn không tồn tại thì nó báo lỗi khi

    // Ngoài ra lớp class chúng ta khởi tạo ban đầu là (enum class Color) trên nó sẽ 1 hàm là "values()"
    // values() hàm này sẽ trả về 1  các giá trị bên trong
    // chúng ta có thể duyệt nó như 1 mảng thông thường như sau
    for(colorValue in Color.values()){
        println("color value is: $colorValue")
    }

    // Ngoài ra chúng ta có thể sử dụng như 1 công tác tắt bật như ví dụ sau
    // Hành động ngược lại
    println(ActionState.ACTIVE.reverseAction())
    println(ActionState.INACTIVE.reverseAction())
}

enum class ActionState{
    ACTIVE{
        override fun reverseAction() = INACTIVE
    },
    INACTIVE{
        override fun reverseAction() = ACTIVE
    };
    abstract fun reverseAction(): ActionState
}