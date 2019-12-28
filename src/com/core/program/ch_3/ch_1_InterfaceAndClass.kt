package com.core.program.ch_3



/**
 * koltin中除显示的延迟初始化，不然就需要指定属性的默认值
 *
 * java8 支持接口方法支持默认实现，在方法有前面加上default
 *
 * 需要注意在Kotlin中是直接支持默认方法的，还有kotlin支持抽象属性，koltin支持默认实现是kotlin编译器有一个静态内部类实现的
 *  val speed
 *      get()=1000
 *  kolitn中接口声明属性
 *
 *kolitn中构造方法支持默认参数
 * koltin构建方法的参数名前可以没有val或者var，如果没有就不会在类中声明忏悔，如果带上就相当于在类中声明了一个同名的属性
 *  kotlin中可以声明多个init方法，是顺序调用的
 *
 *  by lazy和lateinit
 *  by lazy变量必须是引用不变的，不能在var来声明上使用，这个在首次调用的时候才会赋值，被赋值过后就不能更改了，因为是给属性加上同步锁参考Bird4
 *  lateinit主要用于var声明的亦是，不能用于基本数据类型，
 *
 *
 *
 *  构造方法，分为主从构造方法
 *  如果主构造方法存在注解或是可见修饰符，也必须像从构造方法加上constructor关键字
 */
class Bird0 {
    val weight: Double = 500.0
    val color: String = "blue"
    val age: Int = 1
    fun fly() {} // 全局可见
}

class Bird1(val weight: Double = 0.00, val age: Int = 0, val color: String = "blue")

class Bird2(val weight: Double = 0.00, val age: Int = 0, val color: String = "blue") {
    init {
        println("do some other things")
        println("the weight is ${this.weight}")
    }
}

class Bird3(weight: Double, age: Int, color: String) {
    val weight: Double
    val age: Int
    val color: String

    init {
        this.weight = weight
        println("The bird's weight is ${this.weight}.")
        this.age = age
        println("The bird's age is ${this.age}.")
    }

    init {
        this.color = color
        println("The bird's age is ${this.color}.")
    }
}

class Bird4(val weight: Double, val age: Int, val color: String) {
    val sex: String by lazy {
        if (color == "yellow") "male" else "female"
    }
    val sex1: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        //并行模式
        if (color == "yellow") "male" else "female"
    }
    val sex2: String by lazy(LazyThreadSafetyMode.NONE) {
        //不做任何线程保证也不会有任何线程开销
        if (color == "yellow") "male" else "female"
    }
}

class Bird5(val weight: Double, val age: Int, val color: String) {
    lateinit var sex: String // sex 可以延迟初始化

    fun printSex() {
        this.sex = if (this.color == "yellow") "male" else "female"
        println(this.sex)
    }
}

interface Flyer {
    val speed: Int
    fun kind()
    fun fly() {
        println("I can fly")
    }
}


fun main(args: Array<String>) {
    val bird = Bird1(1000.0, 2, "blue")
    println(bird)
}