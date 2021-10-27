package hello

// Hàm cơ bản
//fun sum(x: Double, y: Double): Double {
//    return x + y
//}


// biến chế hàm biểu thức lambda trên (phía bên trái mũi tên có các đầu vào, phía bên phải mũi tên có phần thực thi)
//val sum = { x: Double, y: Double -> x + y } // cách 1
//val sum:(Double, Double) -> Double = {x, y -> x + y} // cách 2

//Anonymous Functions hàm nặc danh
var sum = fun(x: Double, y: Double): Double{
    return x + y
}

//Anonymous Function without return value (Hàm không tên không trả về giá trị)
var sayHello = fun(personName: String){
    println("This is an anonymous func tion")
    println("Hello $personName")
}

fun main() {
    println("Sum = ${sum(10.1, 11.2)}")
    sayHello("Tohn")
    var doubles = doubleArrayOf(10.0, 11.1, 12.2, 13.3, 14.4)
    doubles.forEach { eachNumber -> println(eachNumber) } // thực thi biểu thức lambda
}