package com.core.program.ch_3

/**
 * kotlin中使用接口多继承，来解决多继承的问题
 * kotlin中内部类解决多继承问题的解决方案（Mule）在kotlin中使用内部类需要使用inner来声明
 * kotlin中使用委托代替多继承，通过by关键字去实现委托，委托还提供了一种可观察的行为
 */
interface Flyer1 {
    fun fly()
    fun kind() = "flying animals"
}

interface Animal {
    val name: String
    fun eat()
    fun kind() = "flying animals"
}

class Bird7(override val name: String) : Flyer1, Animal {
    override fun eat() {
        println("I can eat")
    }

    override fun fly() {
        println("I can fly")
    }

    // 这个来解决多继承的问题，指明调用某一个方法
    override fun kind() = super<Flyer1>.kind()
}

open class Horse { //马
    fun runFast() {
        println("I can run fast")
    }
}

open class Donkey { //驴
    fun doLongTimeThing() {
        println("I can do some thing long time")
    }
}

class Mule {  //骡子
    fun runFast() {
        HorseC().runFast()
    }

    fun doLongTimeThing() {
        DonkeyC().doLongTimeThing()
    }

    private inner class HorseC : Horse()
    private inner class DonkeyC : Donkey()
}


interface CanFly {
    fun fly()
}

interface CanEat {
    fun eat()
}

open class Flyer2 : CanFly {
    override fun fly() {
        println("I can fly")
    }
}

open class Animal2 : CanEat {
    override fun eat() {
        println("I can eat")
    }
}

class Bird8(flyer: Flyer2, animal: Animal2) : CanFly by flyer, CanEat by animal {}

fun main(args: Array<String>) {
    val flyer = Flyer2()
    val animal = Animal2()
    val b = Bird8(flyer, animal)
    b.fly()
    b.eat()
}