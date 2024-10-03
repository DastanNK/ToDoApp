package com.example.todoapp.database



sealed class Items(val id:Int,
                   var doing:String,
                   var isVisible:Boolean=true){
    object FirstItem:Items(0, "ddkdkdkdkdkdkkdkddkkdkddddddddkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkksssssssssssssssssssssssssssssssssss")
    object SecItem:Items(1, "[f[")
    object ThirdItem:Items(2, "lflf")
    object ForthItem:Items(3, "s;a;", isVisible = false)


}

val Item= arrayOf(Items.FirstItem, Items.SecItem, Items.ThirdItem, Items.ForthItem)