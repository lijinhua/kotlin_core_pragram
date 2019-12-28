package com.core.program.ch_3

/**
 * 数据类必须拥有一个构造方法，该方法至少包含一个参数，
 * 类构造方法的参数强制使用var或者val进行声明
 * data class之前不能用abstract、open,sealed或者是inner进行修饰
 * 在koltin1.1版本之前数据只允许实现接口，之后的版本既可以实现接口也可以继承类
 */
data class Bird9(var weight: Double, var age: Int, var color: String)

fun main(args: Array<String>) {
    val b1 = Bird9(weight = 1000.0, age = 1, color = "blue")
    val b2 = Bird9(weight = 1000.0, age = 1, color = "blue")
    println(b1.equals(b2))
    println(b1 == b2)

    // 声明bird属性不可变，也是前拷贝
    b1.copy(age = 2)

    // 将类的属性绑定到变量上
    val (weight, age, color) = b1
    println("weight: $weight, age: $age, color: $color")

    // 解构，数组默认最多允许赋值5个变量，如果过多会是的其反
    val birdInfo = "20.0,1,blue"
    val (weightA, ageA, colorA) = birdInfo.split(",")
    println("weightA: $weightA, ageA: $ageA, colorA: $colorA")

    // Pair是二元组，可以理解为这个数据类中有两个属性，
    val pair = Pair(20.0,1)
    val triple = Triple(20.0, 1,"blue")

    val (weightP, ageP) = pair // 这个是解构
    println("weightP: $weightP, ageP: $ageP")
    // triple三元组，对应的是3个属性
    val (weightT, ageT, colorT) = triple
    println("weightT: $weightT, ageT: $ageT, colorT: $colorT")
}
