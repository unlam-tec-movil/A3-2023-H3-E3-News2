package ar.edu.unlam.mobile2.data.guest.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GuestEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val username: String?)