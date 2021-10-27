
package hello

import kotlin.reflect.KProperty

// Delegated properties là gì: Nó là việc chúng ta uỷ quyền từ 1 class này cho 1 class khác
// thực  hiện các hàm getter  của cái thuộc tính nào
// ví dụ minh hoạ sau:

class User{
    var todayTasks: String by DelegatedUser()
}

class DelegatedUser{
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String{ // (KProperty là kotlin property) (thisRef là cái object trỏ đến class User, kiểu của nó là kiểu Any tức là chúng ta định nghĩa các class khác thì cũng ok)
        return "$thisRef, cảm ơn vì đã ủy quyền '${property.name}' với tôi!" // property.name trả về giá trị todayTasks (giá trị trả ra có thể tuỳ chỉnh)
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){ // setValue sẽ được gọi khi chúng ta gán bằng 1 cái giá trị gì đấy (value ở đây là giá trị mới gán vào)
        println("phân công '${property.name} trong $thisRef. Thông tin chi tiết: $value'")
    } 
}

fun main() {
    // cách gọi
    var user = User()
    println(user.todayTasks) // gọi getter
    user.todayTasks = "Tôi tạo một video hướng dẫn mới trong Kotlin" // gọi setter
}