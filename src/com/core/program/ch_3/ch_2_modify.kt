package com.core.program.ch_3


/**
 * koltin使用:号继承和实现
 * koltin中类和方法默认是不可被继承或重写，所以必须加上open
 *
 * koltin还可以通过sealed关键字来修饰一个类为密封类，若要继承则需要将子类定义在同一个文件中，其他文件中的
 * 类将无法继承它，但这种方式有它的局限性，即它不能被初始化，因为它背后是基于抽象去做的
 * kotlin中的abstract与java的完全一样
 *
 * 可见修饰符
 * kolitn与java默认修饰符不同，kolitn中是public，java是default
 * koltin中有一种internal，模块内访问，一个工程是属于一个模块
 * kotlin与java的protected访问范围不同,java是包，类及子类可以访问，而kolitn只允许类和子类
 */
open class Bird6 {
    open fun fly() {
        println("I can fly.")
    }
}

class Penguin : Bird6() {
    override fun fly() {
        println("I can't fly actually.")
    }
}


private open class Engine(val type: String) {
    protected open fun engineType(): String {
        return "the engine type is $type"
    }
}

private class BZEngine(type: String) : Engine(type) {
    override fun engineType(): String {
        return super.engineType()  //ok
    }
}