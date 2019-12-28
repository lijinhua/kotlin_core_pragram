package com.core.program.ch_3


import java.util.*

/**
 * 在kotlin中你将告别static,它引用了一个全新的关键字object,
 * koltin中引用了伴生对象，companion object两个关键字
 */
class Prize0(val name: String, val count: Int, val type: Int) {
    companion object {
        val TYPE_REDPACK = 0
        val TYPE_COUPON = 1

        fun isRedpack(prize: Prize0): Boolean {
            return prize.type == TYPE_REDPACK
        }
    }
}
// 伴生对象实现工厂方法模式
class Prize1 private constructor(val name: String, val count: Int, val type: Int) {
    companion object {
        val TYPE_COMMON = 1
        val TYPE_REDPACK = 2
        val TYPE_COUPON = 3


        val defaultCommonPrize = Prize1("普通奖品", 10, TYPE_COMMON)

        fun newRedpackPrize(name: String, count: Int) = Prize1(name, count, TYPE_REDPACK)
        fun newCouponPrize(name: String, count: Int) = Prize1(name, count, TYPE_COUPON)
        fun defaultCommonPrize() = defaultCommonPrize
    }
}
// koltin中实现单例模式使用object
object DatabaseConfig {
    var host: String = "127.0.0.1"
    var port: Int = 3306
    var username: String = "root"
    var password: String = ""
}

// koltin中使用objecgt代码匿名内部类
val comparator0 = object : Comparator<String> {
    override fun compare(s1: String?, s2: String?): Int {
        if (s1 == null)
            return -1
        else if (s2 == null)
            return 1
        return s1.compareTo(s2)
    }
}
// 使用lambda表达来代替匿名内部类
val comparator1 = Comparator<String> { s1, s2 ->
    if (s1 == null)
        return@Comparator -1
    else if (s2 == null)
        return@Comparator 1
    s1.compareTo(s2)
}

// 上面的下面这个哪个更适合在什么时机用，lambd只有一个方法造合用，使用object表达式适合多个方法
fun main(args: Array<String>) {
    val prize = Prize0("红包", 10, Prize0.TYPE_REDPACK)
    print(Prize0.isRedpack(prize))

    val redpackPrize = Prize1.newRedpackPrize("红包", 10)
    val couponPrize = Prize1.newCouponPrize("十元代金券", 10)
    val commonPrize = Prize1.defaultCommonPrize()

    val list = listOf("redpack", "score", "card")
    Collections.sort(list, comparator0)
    Collections.sort(list, comparator1)
}