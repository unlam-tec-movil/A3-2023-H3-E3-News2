package ar.edu.unlam.mobile2.data.guest.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ar.edu.unlam.mobile2.data.guest.local.entity.GuestEntity

@Dao
interface GuestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGuest(guestEntity: GuestEntity)

    @Query("SELECT * FROM GuestEntity")
    suspend fun getGuests(): List<GuestEntity>
}