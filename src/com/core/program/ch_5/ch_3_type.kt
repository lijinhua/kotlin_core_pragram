package com.core.program.ch_5

/**
 * Created by prefert on 2019/5/13.
 *  * 类型检查
 *  在java中我们使用instanceof来判断，在kotlin中我们使用is来判断
 *  if(obj !is String){ 等同于if(!(obj is String))
 *
 */
fun typeCheckA(obj: Any) {
    if (obj is String) {
        print(obj.length)
    }
    if (obj !is String) { // 等同于 !(obj is String) print("Not a String")
    } else {
        print(obj.length)
    }
}

fun typeCheckB(obj: Any) {
    when (obj) {
        is String -> print(obj.length)
        else      -> print("Not a String")
    }
}


fun main(args: Array<String>) {
    typeCheckB(1024)
    typeCheckB("Prefer.t")
}