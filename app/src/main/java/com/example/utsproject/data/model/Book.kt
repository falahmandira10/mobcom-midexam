package com.example.utsproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

enum class Genre {
  ROMANCE,
  MISTERY,
  FANTASY
}

@Entity(tableName = "books")
data class Book(
  @PrimaryKey(autoGenerate = true) val id: Int,
  val title: String,
  val author: String,
  val publicationYear: Int?,
  val genre: Genre?,
  val summary: String?
)
