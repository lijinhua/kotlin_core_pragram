package com.core.program.ch_2

/**
 * Author: lijinhua
 * Date: 2019-11-12 20:13
 * Description:
 * History: lambda表达式
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
class c_3_lambdaAndHof{

}
// 演示的是函数里面套函数
fun foo(x:Int){
    fun double(y:Int):Int{
        return y*2
    }
    println(double(1))
}

// 下面这个是函数作为参数的需求
// 在koltin中的函数类型声明
/**
 * (Int) ->Unit
 * 左边是参数类型   右边是返回值类型
 * 必须用括号包起来
 * 返回值类型也必须显示声明
 * ()->Unit
 * (Int,String) -> Unit
 * 指定参数
 * (errCode:Int,errMsg:String) ->Unit
 * ((errCode:Int,errMsg:String) ->Unit)?表示整个函数变成了可选
 *
 * 高阶函数还支持返回另一个函数
 * (Int)->((Int)->Unit)
 * 表示传入一个类型为Int的参数 ，然后返回另一个类型为(Int)->Unit的函数，简化它的形式 (Int)->Int->Unit
 *
 * ((Int)->(Int))->Unit
 * 表示传一个函数类型的参数，返回一个Unit
 */
data class Country(
        val name: String,
        val continient: String,
        val population: Int)

class CountryApp {
    fun filterCountries(
            countries: List<Country>,
            test: (Country) -> Boolean): List<Country> // 增加了一个函数类型的参数test
    {
        val res = mutableListOf<Country>()
        for (c in countries) {
            if (test(c)) { // 直接调用test来进行筛选
                res.add(c)
            }
        }
        return res
    }
}


class CountryTest {
    fun isBigEuropeanCountry(country: Country): Boolean {
        return country.continient == "EU" && country.population > 10000
    }
}

fun countryFilterTest() {
    val countryApp = CountryApp()
    val countryTest = CountryTest()
    val countries = listOf(Country("China", "Asia", 1300000000))

    /**
     * 方法和成员引用：
     * 通过两个冒号来实现对于某个类的方法引用
     *  countryTest::isBigEuropeanCountry
     *
     *  两个冒号来定义一个类的构建方法引用：
     *  class Book(val name:String)
     *
     *  val getBook=::Book 构建方法引用
     *  println(getBook("name").name)
     *
     *  getBook的类型为(name:String)->Book
     *  引用成员变量
     *     Book::name 的类型为(Book)->String
     */
    countryApp.filterCountries(countries, countryTest::isBigEuropeanCountry)
    // 下面这个fun(country是匿名函数
    countryApp.filterCountries(countries, fun(country: Country): Boolean {
        return country.continient == "EU" && country.population > 10000
    })
    // 下面这个lambda的语法糖，可以省略fun,和返回值，通过   {参数--->实现}
    countryApp.filterCountries(countries, { country ->
        country.continient == "EU" && country.population > 10000
    })
}

fun lambdaDef() {

    // lambda的定义
    /**
     * 一个lambda必须通过{}包果
     * 如果lambda声明了参数部分类型，返回值类型可以不写{ x: Int, y: Int ->x + y}
     *  默认lambda最后一行就是返回值
     */
    val sum0: (Int, Int) -> Int = { x: Int, y: Int ->
        x + y
    }
    val sum1 = { x: Int, y: Int ->
        x + y
    }

    val sum2: (Int, Int) -> Int = { x, y ->
        x + y
    }

    println(sum0(1, 1))
    println(sum1(1, 1))
    println(sum2(1, 1))
}

fun funInvoke() {
    // fun声明lambda函数表达式
    fun foo(i: Int) = {
        print(i)
    }
    // 下面这个it就是单个参数的隐式名称
    listOf(1, 2, 3).forEach { foo(it) }
    listOf(1, 2, 3).forEach { item->foo(item) }
    // 上面两个等价，默认情况下it代表itme,而不需要用item->进行声明，上面两行执行了什么都没有，可以转成java代码看原因
    // 现在才是调用函数的本身写法
    listOf(1, 2, 3).forEach { foo(it).invoke() }
    listOf(1, 2, 3).forEach { foo(it)() }
}

fun selfRunLambda() {
    { x: Int -> println(x) }(0)
}

fun curryLike() {
    fun <A, B> Array<A>.corresponds(that: Array<B>, p: (A, B) -> Boolean): Boolean {
        val i = this.iterator()
        val j = that.iterator()
        while (i.hasNext() && j.hasNext()) {
            if (!p(i.next(), j.next())) {
                return false
            }
        }
        return !i.hasNext() && !j.hasNext()
    }

    val a = arrayOf(1, 2, 3)
    val b = arrayOf(2, 3, 4)
    a.corresponds(b) { x, y -> x + 1 == y } // true
    a.corresponds(b) { x, y -> x + 2 == y } // false
}

fun main(args: Array<String>) {
    println("--------------------------------------")
    countryFilterTest()
    funInvoke()
    selfRunLambda()
}