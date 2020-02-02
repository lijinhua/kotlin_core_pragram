package com.core.program.ch_5

/**
 * Created by prefert on 2019/5/13.
 * 类型转换
 * 当类型需要强转时，可以通过as来实现
 */
fun <T> castA(original: Any): T? = original as? T

inline fun <reified T> cast(original: Any): T? = original as? T


fun main(args: Array<String>) {
    // java.lang.Long cannot be cast to java.lang.String
//    val ansA = castA<String>(140163L)

    val ans = cast<String>(140163L)

    println(ans)
}