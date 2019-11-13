package com.core.program.ch_2

/**
 * Author: lijinhua
 * Date: 2019-11-12 14:10
 * Description:
 * History: 声明函数返回值类型
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
fun main(args: Array<String>) {
    varInfers()
}

fun varInfers() {
    val string = "I am Kotlin"
    val int = 1314
    val long = 1314L
    val float = 13.14f
    val double = 13.34
    val double2 = 10.1e6

    val vars = listOf(string, int, long, float, double, double2)
    vars.forEach { println(it.javaClass.name) }
}

// 函数指定返回值类型
fun sum0(x: Int, y: Int): Int {
    return x + y
}

//kotlin支付单行表达式与等号的语法，叫作表达式函数体，返回值类型自动推导
fun sum1(x: Int, y: Int) = x + y

//在复杂的情况需要显示声明返回的类型，递归函数需指定返回值类型
fun fib(i: Int): Int {
    return when {
        i == 0 -> 0
        i == 1 -> 1
        else -> fib(i - 1) + fib(i - 2)
    }
}