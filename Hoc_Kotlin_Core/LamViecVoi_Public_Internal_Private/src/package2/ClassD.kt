package package2
import package1.ClassA

open class ClassD {
    // protected Nếu mà ở ngoài lớp  thì chúng ta sẽ ko truy cập được vào lúc đó nó như 1 private
    // protected Nếu mà ở bên trong lóp con thì nó có thể truy cập và sửa được  mình override được
    // protected có thể cho kế thừa được open
    protected open val p1 = 1
    // public có thể được kế thừa open còn private thì ko
    public open var z = 10

    init {
        println("Khối khởi tạo ClassD")
    }
}

class SubClassD: ClassD(){
    override val p1 = 2
    override var z = 200
}

public fun function4(){
    println("This is function4")
    var classA = ClassA()
}