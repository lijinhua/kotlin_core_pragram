package com.core.program.ch_4

/**
 * 代数数据类型(algebraic data type adt),教你如何用密封类，数据类去构建一个代数数据类型，
 * https://juejin.im/post/5a37e4b45188253aea1f7219#heading-8
 * 什么是密封类
 *      密封类是受限的类继承结构，即当类中的一个值只能是有限的几种类型，而不能是其他的任何类型，它相当于枚举类的扩展
 *      也可以说成，密封类是包含了一组受限的类集合，因为里面的类都是继承自这个密封类的。但是其和其他继承类（open）的区别在，密封类可以不被此文件外被继承，有效保护代码。但是，其密封类的子类的扩展是是可以在程序中任何位置的，即可以不在同一文件下。
 * adt最大的好处就是可以很放心的使用when表达式
 * */

sealed class Shape {
    class Circle(val radius: Double) : Shape()
    class Rectangle(val width: Double, val height: Double) : Shape()
    class Triangle(val base: Double, val height: Double) : Shape()
}

fun getArea(shape: Shape): Double = when (shape) {
    is Shape.Circle -> Math.PI * shape.radius * shape.radius
    is Shape.Rectangle -> shape.width * shape.height
    is Shape.Triangle -> shape.base * shape.height / 2.0
}