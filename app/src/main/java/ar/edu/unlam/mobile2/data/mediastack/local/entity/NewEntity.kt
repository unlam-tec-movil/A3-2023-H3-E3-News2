package ar.edu.unlam.mobile2.data.mediastack.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val author: String?,
    val category: String?,
    val country: String?,
    val description: String?,
    val image: String?,
    val language: String?,
    val publishedAt: String?,
    val source: String?,
    val title: String?,
    val url: String?,
    val saved: Boolean
)
