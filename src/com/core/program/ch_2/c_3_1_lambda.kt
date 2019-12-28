package com.core.program.ch_2

/***
 * 函数、lambda和闭包
 * fun 在没有等号、只有花扩号的时候，不是unit返回类型的，必须带return
 *
 * fun如果有等号的，可以省略return
 * fun foo(x:Int,y:Int)= x+y
 *
 * 不管是val和fun，如果是等号加花扩号，就是一个lambda表达式，必须通过()或者是invoke来调用lambda,如：
 * val foo = {x:Int,y:Int->x+y}// foo.invoke(1,2) 或foo(1,2)
 * fun foo(x:Int)= {y:Int->x+y} // foo(1).invoke(2) 或者是foo(1)(2)
 *  上面这个相当于函数里面创建函数
 *
 * */

fun foo1(x:Int)= {y:Int->x+y}
// 和上面这个等价
fun foo2(x:Int):(Int)->Int{
    return {y:Int->x+y}

}

/**
 * 柯里化指的是把接收多个参数的函数变换成一系列仅接收单一参数的过程
 *
 * **/
fun sum0(x:Int,y:Int,z:Int)=x+y+z
fun sum1(x:Int)={y:Int->{z:Int->x+y+z}}

/**
 * lambda存在特殊语法，如果一个函数只有一个参数，且该参数为函数类型，那么在调用该函数的时候，外面的括号就可以省略
 */
fun omitParenttheses(book:()->Unit){
    book()
}

fun curryingLink(content:String,book:(String)->Unit){
    book(content)
}
fun main(args: Array<String>) {
    println("--------------------------------------")
    println(foo1(1)(2))

    omitParenttheses {
        println("parenthesees is omitted")
    }

    curryingLink("looks linke currying style"){
        content->println(content)
    }
    curryingLink("looks linke currying style",{
        content->println(content)
    })
}