package com.core.program.ch_5

/**
 * java中的泛型
 * https://github.com/jeasonlzy/okhttp-OkGo/wiki/JsonCallback
 * 在kotlin中使用泛型
 *
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

class SmartList<T> : ArrayList<T> () {
    fun find(t: T): T? {
        val index = super.indexOf(t)
        return if (index >= 0) super.get(index) else null
    }
}

fun <T> ArrayList<T>.find(t: T): T? {
    val index = this.indexOf(t)
    return if (index >= 0) this.get(index) else null
}

class Plate<T>(val t: T)

open class Fruit(val weight: Double)

class Apple(weight: Double): Fruit(weight)
class Banana(weight: Double): Fruit(weight)

class FruitPlate<T: Fruit>(val t: T)

// 面条类
class Noodles(weight: Double)

// 地
interface Ground{}

// 西瓜
class Watermelon(weight: Double): Fruit(weight), Ground
// 刀
fun <T> cut(t: T) where T: Fruit, T: Ground {
    print("You can cut me")
}

fun main(args: Array<String>) {
    // koltin中定义泛型
    val smartList = SmartList<String>()
    smartList.add("one")
    println(smartList.find("one"))
    println(smartList.find("two").isNullOrEmpty())

    // 使用泛型扩展函数来解决
    val arrayList = ArrayList<String>()
    arrayList.add("one")
    println(arrayList.find("one"))
    println(arrayList.find("two").isNullOrEmpty())

    // 泛型类型约束 FruitPlate<T: Fruit>(val t: T)
    val applePlate = FruitPlate<Apple>(Apple(100.0))

    // val noodlesPlate = FruitPlate<Noodles>(Noodles(100.0)) 不允许
    // 泛型的多个约束参数
    cut(Watermelon(3.0))

    // cut(Apple(2.0)) 不允许
}