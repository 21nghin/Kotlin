package hello

import swap2Elements

fun main() {
// ví dụ đổi chỗ 2 vị trí phần tử cho nhau
    val listOfStrings:MutableList<String> = mutableListOf("Zero", "One", "two", "three", "Four")
    listOfStrings.swap2Elements(0, 3)
    println("listOfString = $listOfStrings")
}