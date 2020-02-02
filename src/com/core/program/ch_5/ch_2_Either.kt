package com.core.program.ch_5

/**
 * Created by prefert on 2019/5/13.
 *
 * let概念
 *  功能：调用某对象的let函数，该对象会作为函数的参数，在函数块内可以通过it指代该对象，返回值为函数块的最后一行或指定return表达式
 *
 * https://leegyplus.github.io/2019/12/03/Kotlin-%E6%A0%B8%E5%BF%83%E7%BC%96%E7%A8%8B-%E5%8D%81%E4%B8%80-%E4%BD%9C%E7%94%A8%E5%9F%9F%E5%87%BD%E6%95%B0/
 *
 *  kotlin中标准的扩展函数
 *      run、with、let、also与apply
 *      https://blog.csdn.net/u013064109/article/details/78786646
 *      https://zhuanlan.zhihu.com/p/37085876

 *  }
 *
 */
sealed class Either<A, B>() {
    class Left<A, B>(val value: A) : Either<A, B>()
    class Right<A, B>(val value: B) : Either<A, B>()
}

fun getDegreeOfMyopiaKt(seat: Seat?): Either<Error, Double> {
    return seat?.student?.glasses?.let {
        Either.Right<Error,
                Double>(it.degreeOfMyopia)
    } ?: Either.Left<Error, Double>(Error("-1"))
}