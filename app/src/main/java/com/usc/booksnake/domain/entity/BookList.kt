package com.usc.booksnake.domain.entity

data class BookList(
    val title : String,
    val subTitle : String,
    val itemList : List<Book>,
    val description : String = "",
    val creator : String
)