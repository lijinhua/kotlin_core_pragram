package com.core.program.ch_4

/**
 * 模式匹配
 * 常量模式
 * 类型模式（上面的ch_1_adt就是类型模式）
 * 逻辑表达式模式
 * 嵌套表达式
 */
fun constantParttern(a:Int) = when(a){
    1->"it is 1"
    2->"it is 2"
    else ->" it is other number"
}

fun logicPattern(a: Int) = when {
    a in 2..11 -> (a.toString() + " is smaller than 10 and bigger than 1")
    else -> "Maybe" + a + "is bigger than 10, or smaller than 1"
}

fun logicPattern(a: String) = when {
    a.contains("Yison") -> "Something is about Yison"
    else -> "It`s none of Yison`s business"
}

sealed class Expr {
    data class Num(val value: Int) : Expr()
    data class Operate(val opName: String, val left: Expr, val right: Expr) : Expr()
}

fun simplifyExpr(expr: Expr): Expr = if (expr is Expr.Num) {
    expr
} else if (expr is Expr.Operate && expr.opName == "+" && expr.left is Expr.Num && expr.left.value == 0) {
    expr.right
} else if (expr is Expr.Operate && expr.opName == "+" && expr.right is Expr.Num && expr.right.value == 0) {
    expr.left
} else expr

fun simplifyExpr1(expr: Expr): Expr = when {
    (expr is Expr.Operate) && (expr.opName == "+") && (expr.left is Expr.Num) && (expr.left.value == 0) -> expr.right
    (expr is Expr.Operate) && (expr.opName == "+") && (expr.right is Expr.Num) && (expr.right.value == 0) -> expr.left
    else -> expr
}

fun simplifyExpr2(expr: Expr): Expr = when (expr) {
    is Expr.Num -> expr
    is Expr.Operate -> when (expr) {
        Expr.Operate("+", Expr.Num(0), expr.right) -> expr.right
        Expr.Operate("+", expr.left, Expr.Num(0)) -> expr.left
        else -> expr
    }
}

fun simplifyExpr3(expr: Expr): Expr = when (expr) {
    is Expr.Num -> expr
    is Expr.Operate -> when (expr) {
        Expr.Operate("+", Expr.Num(0), expr.right) -> simplifyExpr(expr.right)
        Expr.Operate("+", expr.left, Expr.Num(0)) -> expr.left
        else -> expr
    }
}

fun simplifyExpr4(expr: Expr): Expr = when (expr) {
    is Expr.Num -> expr
    is Expr.Operate -> when {
        (expr.left is Expr.Num && expr.left.value == 0) && (expr.right is Expr.Operate) ->
            when (expr.right) {
                Expr.Operate("+", expr.right.left, Expr.Num(0)) -> expr.right.left
                else -> expr.right
            }
        else -> expr
    }
}