package com.example.filehandling

class Sorsolasok {
    var week:Int
    var num1:Int
    var num2:Int
    var num3:Int
    var num4:Int
    var num5:Int

    constructor(week : String,num1 : String, num2 : String, num3 : String, num4 : String , num5 : String ){
        this.week=week.toInt()
        this.num1=num1.toInt()
        this.num2=num2.toInt()
        this.num3=num3.toInt()
        this.num4=num4.toInt()
        this.num5=num5.toInt()
    }
}