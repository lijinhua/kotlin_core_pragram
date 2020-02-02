package com.core.program.ch_5

/**
 * Created by prefert on 2019/5/13.
 * kotlin的Any类型
 *
 * kotlin中的type checker强制检查了父子关系，例如
 * 你可以将子类型值存储到父类型变量中去
 * 但是不能将父类型值存储到子类型变量去
 * java中的object相当于koltin中的any类型
 */
abstract class Animal(val weight: Double)
class Fish(weight: Double, val swimmingSpeed: Double): Animal(weight)


interface ICanFly
interface ICanBuildNest
class Bird(weight: Double, flightSpeed: Double): Animal(weight), ICanFly,
        ICanBuildNest

fun main(args: Array<String>) {
    var birdA: Animal = Bird(weight = 0.1, flightSpeed = 15.0)
    birdA = Fish(weight = 0.15, swimmingSpeed = 10.0)

    val birdB = Bird(weight = 0.1, flightSpeed = 15.0)
    val animal: Animal = birdB
    // Error: Type mismatch: inferred type is Animal but Bird was expected
//    val b2: Bird = animal
}