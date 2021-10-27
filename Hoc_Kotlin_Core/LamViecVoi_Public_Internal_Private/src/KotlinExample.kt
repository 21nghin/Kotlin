package hello

import package1.ClassB
import package2.function4

fun main() {
    // function4 là 1 function public có thể gọi ở bất cứ đâu vào
    function4()
    // internal class: có thể truy cập vào một package bên trong co thể gọi được  còn ngoài package vẫn gọi được nhưng chúng ta cần import packgae đó
    // internal sẽ gọi được bất cứ đâu và chỉ ra ở package nào
    var classB = ClassB()
}