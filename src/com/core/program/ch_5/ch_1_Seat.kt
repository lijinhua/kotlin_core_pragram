package com.core.program.ch_5

/**
 * Created by prefert on 2019/5/13.
 * 声明可空类型
 *  在类型后面加上？
 *  https://blog.csdn.net/lckj686/article/details/80448471
 * 1、安全调用?.
 * 这里面的?.我们称为安全调用，${s.student?.glasses?.degree}
 *  对应的java代码
 *  if(s.student!=null){
 *      if(s.student.glasses!=null){
 *          s.student.glasses.degree
 *      }
 *  }
 *  当student存在的时候，才会调用其下的glasses
 *
 *  2、Elvis操作符?:
 *     java的三目运算符
 *     double result=student.glasses!=null?student.glasses:-1
 *     var result = student.glasses?.degressOfMyopia?:-1
 *  3、非空断言!!
 *
 */
data class Seat(val student: Student?)
data class Student(val glasses: Glasses?)
data class Glasses(val degreeOfMyopia: Double)