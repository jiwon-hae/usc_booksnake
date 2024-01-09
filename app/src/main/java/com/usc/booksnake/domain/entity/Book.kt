package com.usc.booksnake.domain.entity

import java.io.Serializable

data class Book(
    val title: String,
    val contributor: String,
    val createdPublished: String,
    val image: List<String>,
    val imageUrl: String,
    val originalFormat: String,
    val onlineFormat: List<String>,
    val subjects: List<String>,
) : Serializable